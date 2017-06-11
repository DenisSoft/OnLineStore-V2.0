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
import ru.belitavitex.util.CategoryTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

/**
 * Created by Dzianis on 02.06.2017.
 */
public class ProductTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        ProductTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testSaveProduct() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Product savedProduct = session.find(Product.class, 1L);
        Assert.assertEquals(savedProduct.getName(), "Бальзам для жирных волос");

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
