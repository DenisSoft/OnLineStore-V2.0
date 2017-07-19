package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.CustomerOrderDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.*;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class CustomerOrderServiceImpl extends BaseServiceImpl<CustomerOrder> implements CustomerOrderService {

    private final CustomerOrderDao customerOrderDao;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderDao customerOrderDao) {
        this.customerOrderDao = customerOrderDao;
    }

    @Override
    protected BaseDao<CustomerOrder> getBaseDao() {
        return customerOrderDao;
    }

    @Override
    public void save(CustomerOrder cart){
        if (cart.getPerson() == null){
            User user = (User) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
            Person person = new Person();
            person.setId(user.getId());
            cart.setPerson(person);
        }
        cart.setDateCreated(LocalDate.now());
        cart.setOrderStatus(OrderStatus.CREATED);
        customerOrderDao.save(cart);
    }

    public boolean delete(Long id) {
        CustomerOrder customerOrder = customerOrderDao.findOne(id);
        if (customerOrder.getOrderStatus() == OrderStatus.CLOSED){
            customerOrderDao.delete(customerOrder);
            return true;
        }
        return false;
    }

    @Override
    public CustomerOrder findOne(Long id){
        CustomerOrder customerOrder = customerOrderDao.findOne(id);
        customerOrder.setOrderItems(customerOrder.getOrderItems()
                .stream().collect(Collectors.toCollection(HashSet::new)));
        return customerOrder;

    }


    public void update(CustomerOrder cart){
        customerOrderDao.save(cart);
    }
}
