package ru.belitavitex.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderStatus;

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

}
