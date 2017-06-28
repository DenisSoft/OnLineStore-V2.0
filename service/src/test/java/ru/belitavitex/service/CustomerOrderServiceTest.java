package ru.belitavitex.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderStatus;
import ru.belitavitex.service.BaseServiceTest;
import ru.belitavitex.service.common.BaseService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class CustomerOrderServiceTest extends BaseServiceTest<CustomerOrder> {

    @Autowired
    private BaseService<CustomerOrder> service;

    @Override
    protected BaseService<CustomerOrder> getService() {
        return service;
    }

    @Override
    protected CustomerOrder getModel() {
        return new CustomerOrder();
    }

}
