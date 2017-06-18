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
public class CustomerOrderTest extends BaseTest<CustomerOrder>{

    @Override
    protected Class<CustomerOrder> getEntityClass() {
        return CustomerOrder.class;
    }

    @Override
    protected CustomerOrder getModel() {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderStatus(OrderStatus.CLOSED);
        customerOrder.setDateClosing(LocalDate.of(2011,03,03));
        customerOrder.setDateCreated(LocalDate.of(2011,03,01));
        customerOrder.setPerson(new Person());
        return new CustomerOrder();
    }
}
