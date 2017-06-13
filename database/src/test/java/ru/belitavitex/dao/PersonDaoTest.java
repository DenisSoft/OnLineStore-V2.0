package ru.belitavitex.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.entity.Address;
import ru.belitavitex.entity.Groups;
import ru.belitavitex.entity.Person;
import ru.belitavitex.util.PersonTestDataImporter;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static ru.belitavitex.dao.BaseDao.SESSION_FACTORY;

/**
 * Created by Dzianis on 13.06.2017.
 */
public class PersonDaoTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonDaoTest.class);

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        PersonDao.getInstance();
        PersonTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testFindAll() {
        List<Person> result = PersonDao.getInstance().findAll();
        assertEquals(result.size(), 3);
    }

    @Test
    public void testFindOne() {
        Person result = PersonDao.getInstance().findOne(1L);
        assertEquals(result.getFirstName(), "Максим");
    }

    @Test
    public void testDelete() {
        Person person = PersonDao.getInstance().findOne(1L);
        PersonDao.getInstance().delete(person);
        Person result = PersonDao.getInstance().findOne(1L);
        assertEquals(result, null);
    }

    @Test
    public void testSave() {
        Person person = new Person("Ирина", "Серебрянная", "serebrynay@bk.ru",
                "4", new Address("Беларусь",
                "Минск", "Ташкенская", 10, 1, 33, "220065"),
                "+375296849034", Groups.USER);
        PersonDao.getInstance().save(person);
        List<Person> result = PersonDao.getInstance().findAll();
        assertEquals(result.size(), 4);
    }

    @Test
    public void testGetPage() {
        List<Person> result = PersonDao.getInstance().getPage(2, 1);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testGetCount() {
        Long result = PersonDao.getInstance().getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testFindByEmailAndPassword() {
        Person result = PersonDao.getInstance().findByEmailAndPassword("mironov@bk.ru", "2");
        assertEquals(result.getFirstName(), "Егор");
    }


    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
