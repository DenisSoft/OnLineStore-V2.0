package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

import java.util.Set;

/**
 * Created by Dzianis on 01.06.2017.
 */
public class PersonTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        PersonTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testSavePerson() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Person savedPerson = session.find(Person.class, 1L);
        Assert.assertEquals(savedPerson.getFirstName(), "Максим");

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
