package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.CustomerOrder;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class CustomerOrderDaoImpl extends BaseDaoImpl<CustomerOrder> implements CustomerOrderDao{
//
//    public CustomerOrderDaoImpl(){
//        super(CustomerOrder.class);
//    }
//
//    public boolean changeStatus(Long id, OrderStatus orderStatus) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        CustomerOrder customerOrder = session.find(CustomerOrder.class,id);
//        customerOrder.setDateClosing(LocalDate.now());
//        customerOrder.setOrderStatus(orderStatus);
//        Boolean isSave = session.save(customerOrder)!= null ? true : false;
//
//        transaction.commit();
//        session.close();
//        return isSave;
//    }
}
