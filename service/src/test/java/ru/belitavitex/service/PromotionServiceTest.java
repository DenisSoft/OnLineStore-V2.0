package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Promotion;
import ru.belitavitex.service.common.BaseService;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class PromotionServiceTest extends BaseServiceTest<Promotion> {

    @Autowired
    private BaseService<Promotion> service;

    @Override
    protected BaseService<Promotion> getService() {
        return service;
    }

    @Override
    protected Promotion getModel() {
        return new Promotion();
    }

}
