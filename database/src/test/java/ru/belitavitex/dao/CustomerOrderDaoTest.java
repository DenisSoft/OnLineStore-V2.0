package ru.belitavitex.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.*;
import ru.belitavitex.util.CustomerOrdersTestDataImporter;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class CustomerOrderDaoTest extends BaseDaoTest<CustomerOrder> {

    @Autowired
    private BaseDao<CustomerOrder> dao;

    @Override
    protected BaseDao<CustomerOrder> getDao() {
        return dao;
    }

    @Override
    protected CustomerOrder getModel() {
        return new CustomerOrder();
    }

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CustomerOrdersTestDataImporter customerOrdersTestDataImporter;

    @Test
    public void testSaveCustomerOrder() {
        customerOrdersTestDataImporter.importTestData();
        Set<OrderItem> orderItems = customerOrderDao.findAll().get(2).getOrderItems();
        assertEquals(orderItems.size(), 3);
    }

    @Test
    public void testQuantityInCart() {
        CustomerOrder customerOrder = new CustomerOrder();
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(3);
        customerOrder.getOrderItems().add(orderItem);
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setQuantity(5);
        customerOrder.getOrderItems().add(orderItem1);
        assertEquals(customerOrder.quantityInCart(), 8);
    }


}
