package ru.belitavitex.dao;

import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Review;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ReviewDaoTest extends BaseDaoTest<Review> {

    private BaseDao<Review> dao = CONTEXT.getBean(ReviewDao.class);

    @Override
    protected BaseDao<Review> getDao() {
        return dao;
    }

    @Override
    protected Review getModel() {
        return new Review();
    }
}
