package ru.belitavitex.dao;

import org.junit.Test;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderStatus;
import ru.belitavitex.util.ProductTestDataImporter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class CustomerOrderDaoTest extends BaseDaoTest<CustomerOrder> {

    private static final CustomerOrderDao CUSTOMER_ORDER_DAO = CONTEXT.getBean(CustomerOrderDao.class);

    private BaseDao<CustomerOrder> dao = CONTEXT.getBean(CustomerOrderDao.class);

    @Override
    protected BaseDao<CustomerOrder> getDao() {
        return dao;
    }

    @Override
    protected CustomerOrder getModel() {
        return new CustomerOrder();
    }

    @Test
    public void testChangeStatus() {
        CustomerOrder customerOrder = new CustomerOrder();
        Long id = CUSTOMER_ORDER_DAO.save(customerOrder).getId();
        CUSTOMER_ORDER_DAO.changeStatus(id, OrderStatus.CLOSED);
        customerOrder = CUSTOMER_ORDER_DAO.findOne(1L);
        assertEquals(customerOrder.getOrderStatus(), OrderStatus.CLOSED);
    }
}
