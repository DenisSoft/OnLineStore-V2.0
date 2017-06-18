package ru.belitavitex.dao;

import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Promotion;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class PromotionDaoTest extends BaseDaoTest<Promotion> {

    private BaseDao<Promotion> dao = CONTEXT.getBean(PromotionDao.class);

    @Override
    protected BaseDao<Promotion> getDao() {
        return dao;
    }

    @Override
    protected Promotion getModel() {
        return new Promotion();
    }
}
