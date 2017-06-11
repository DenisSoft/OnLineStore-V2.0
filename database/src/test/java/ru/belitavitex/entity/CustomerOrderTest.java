package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

import java.time.LocalDate;

/**
 * Created by Dzianis on 07.06.2017.
 */
public class CustomerOrderTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        PersonTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
        ProductTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testSaveCustomerOrder() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setPerson(session.find(Person.class, 1L));
        customerOrder.setDateCreated(LocalDate.now());
        customerOrder.setOrderStatus(OrderStatus.CREATED);
        session.saveOrUpdate(customerOrder);
        OrderItem orderItem1 = new OrderItem(customerOrder, session.find(Product.class, 1L), 3);
        OrderItem orderItem2 = new OrderItem(customerOrder, session.find(Product.class, 2L), 1);
        OrderItem orderItem3 = new OrderItem(customerOrder, session.find(Product.class, 3L), 5);
        session.saveOrUpdate(orderItem1);
        session.saveOrUpdate(orderItem2);
        session.saveOrUpdate(orderItem3);
        customerOrder.getOrderItems().add(orderItem1);
        customerOrder.getOrderItems().add(orderItem2);
        customerOrder.getOrderItems().add(orderItem3);
        session.saveOrUpdate(customerOrder);

        CustomerOrder saveCustomerOrder = session.find(CustomerOrder.class, 1L);
        Assert.assertEquals(saveCustomerOrder.getOrderItems().size(), 3);

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
