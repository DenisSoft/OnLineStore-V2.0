package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.*;

import java.time.LocalDate;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class CustomerOrderDao extends BaseDao<CustomerOrder> {

    public CustomerOrderDao(){
        super(CustomerOrder.class);
    }

    public boolean changeStatus(Long id, OrderStatus orderStatus) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CustomerOrder customerOrder = session.find(CustomerOrder.class,id);
        customerOrder.setDateClosing(LocalDate.now());
        customerOrder.setOrderStatus(orderStatus);
        Boolean isSave = session.save(customerOrder)!= null ? true : false;

        transaction.commit();
        session.close();
        return isSave;
    }
}
