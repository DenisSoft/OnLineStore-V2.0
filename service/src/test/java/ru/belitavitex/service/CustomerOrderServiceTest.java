package ru.belitavitex.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.belitavitex.config.TestServiceConfig;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderStatus;
import ru.belitavitex.entity.Person;
import ru.belitavitex.service.BaseServiceTest;
import ru.belitavitex.service.common.BaseService;
import ru.belitavitex.util.PersonTestDataImporter;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Dzianis on 18.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestServiceConfig.class)
@Transactional
public class CustomerOrderServiceTest  {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Autowired
    private PersonService personService;


    @Test
    public void testSave(){
        CustomerOrder customerOrder = new CustomerOrder();
        personTestDataImporter.importTestData();
        Person person = personService.findAll().get(0);
        customerOrder.setPerson(person);
        customerOrderService.save(customerOrder);
        Long id = customerOrder.getId();
        assertNotNull(customerOrderService.findOne(id));
        assertNotNull(customerOrderService.findAll());
        customerOrderService.delete(customerOrder);
    }
}
