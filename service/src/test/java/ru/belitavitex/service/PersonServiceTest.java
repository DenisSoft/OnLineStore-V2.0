package ru.belitavitex.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.Person;
import ru.belitavitex.service.BaseServiceTest;
import ru.belitavitex.service.common.BaseService;
import ru.belitavitex.util.PersonTestDataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dzianis on 13.06.2017.
 */

public class PersonServiceTest extends BaseServiceTest<Person> {

    @Autowired
    private BaseService<Person> service;

    @Override
    protected BaseService<Person> getService() {
        return service;
    }

    @Override
    protected Person getModel() {
        return new Person();
    }

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Test
    public void testGetPage() {
        personTestDataImporter.importTestData();
        List<Person> result = personService.getPage(2, 1);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testGetCount() {
        personTestDataImporter.importTestData();
        Long result = personService.getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testFindByEmail() {
        personTestDataImporter.importTestData();
        Person result = personService.findByEmail("mironov@bk.ru");
        assertEquals(result.getFirstName(), "Егор");
    }
}
