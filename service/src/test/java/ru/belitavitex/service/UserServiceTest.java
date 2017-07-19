package ru.belitavitex.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.belitavitex.config.TestServiceConfig;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Person;
import ru.belitavitex.service.common.BaseService;
import ru.belitavitex.util.PersonTestDataImporter;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dzianis on 17.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestServiceConfig.class)
@Transactional
public class UserServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Test
    public void testloadUserByUsername() {
        personTestDataImporter.importTestData();
        Person person = personService.findAll().get(0);
        assertNotNull(userService.loadUserByUsername(person.getEmail()));
    }
}
