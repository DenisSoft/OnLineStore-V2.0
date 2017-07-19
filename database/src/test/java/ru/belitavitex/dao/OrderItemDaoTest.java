package ru.belitavitex.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.OrderItem;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Review;
import ru.belitavitex.util.CustomerOrdersTestDataImporter;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dzianis on 10.07.2017.
 */
public class OrderItemDaoTest extends BaseDaoTest<OrderItem> {

    @Autowired
    private BaseDao<OrderItem> dao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CustomerOrdersTestDataImporter customerOrdersTestDataImporter;

    @Override
    protected BaseDao<OrderItem> getDao() {
        return dao;
    }

    @Override
    protected OrderItem getModel() {
        return new OrderItem();
    }

    @Test
    public void testSaveCustomerOrder() {
        customerOrdersTestDataImporter.importTestData();
        List<Product> bestSellers = orderItemDao.getBestSellers();
        assertEquals(bestSellers.size(), 3);
    }
}
