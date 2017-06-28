package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.CustomerOrderDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.service.common.BaseServiceImpl;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class CustomerOrderServiceImpl extends BaseServiceImpl<CustomerOrder> implements CustomerOrderService {

    private final CustomerOrderDao customerOrderDao;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderDao customerOrderDao) {
        this.customerOrderDao = customerOrderDao;
    }

    @Override
    protected BaseDao<CustomerOrder> getBaseDao() {
        return customerOrderDao;
    }
}
