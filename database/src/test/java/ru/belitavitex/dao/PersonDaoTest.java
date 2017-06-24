package ru.belitavitex.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.Person;
import ru.belitavitex.util.PersonTestDataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dzianis on 13.06.2017.
 */

public class PersonDaoTest extends BaseDaoTest<Person> {

    @Autowired
    private BaseDao<Person> dao;

    @Override
    protected BaseDao<Person> getDao() {
        return dao;
    }

    @Override
    protected Person getModel() {
        return new Person();
    }

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Test
    public void testGetPage() {
        personTestDataImporter.importTestData();
        List<Person> result = personDao.getPage(2, 1);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testGetCount() {
        personTestDataImporter.importTestData();
        Long result = personDao.getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testFindByEmailAndPassword() {
        personTestDataImporter.importTestData();
        Person result = personDao.findByEmailAndPassword("mironov@bk.ru", "2");
        assertEquals(result.getFirstName(), "Егор");
    }
}
