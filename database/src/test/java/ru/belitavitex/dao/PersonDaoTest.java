package ru.belitavitex.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.belitavitex.entity.Person;
import ru.belitavitex.util.PersonTestDataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dzianis on 13.06.2017.
 */

public class PersonDaoTest extends BaseDaoTest<Person> {

    private static final PersonDao PERSON_DAO = CONTEXT.getBean(PersonDao.class);
    private BaseDao<Person> dao = PERSON_DAO;

    @Override
    protected BaseDao<Person> getDao() {
        return dao;
    }

    @Override
    protected Person getModel() {
        return new Person();
    }

    @Test
    public void testGetPage() {
        PersonTestDataImporter.importTestData(sessionFactory);
        List<Person> result = PERSON_DAO.getPage(2, 1);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testGetCount() {
        PersonTestDataImporter.importTestData(sessionFactory);
        Long result = PERSON_DAO.getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testFindByEmailAndPassword() {
        PersonTestDataImporter.importTestData(sessionFactory);
        Person result = PERSON_DAO.findByEmailAndPassword("mironov@bk.ru", "2");
        assertEquals(result.getFirstName(), "Егор");
    }
}
