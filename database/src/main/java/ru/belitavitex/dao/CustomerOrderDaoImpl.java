package ru.belitavitex.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderItem;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class CustomerOrderDaoImpl extends BaseDaoImpl<CustomerOrder> implements CustomerOrderDao{

    @Override
    public void save(CustomerOrder customerOrder){
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(customerOrder);
        Set<OrderItem> set = customerOrder.getOrderItems()
                .stream().peek((c) -> c.setCustomerOrder(customerOrder)).collect(Collectors.toSet());
        customerOrder.setOrderItems(set);
    }

    public void update(CustomerOrder customerOrder){
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(customerOrder);
    }

    @Override
    public void delete(CustomerOrder customerOrder){
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(customerOrder);
        customerOrder.getOrderItems();
        session.delete(customerOrder);
    }
}
