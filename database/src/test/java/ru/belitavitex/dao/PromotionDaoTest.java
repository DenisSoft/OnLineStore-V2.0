package ru.belitavitex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Promotion;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class PromotionDaoTest extends BaseDaoTest<Promotion> {
    @Autowired
    private BaseDao<Promotion> dao;

    @Override
    protected BaseDao<Promotion> getDao() {
        return dao;
    }

    @Override
    protected Promotion getModel() {
        return new Promotion();
    }

}
