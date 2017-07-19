package ru.belitavitex.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Promotion;
import ru.belitavitex.entity.Review;

import static org.junit.Assert.*;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ReviewDaoTest extends BaseDaoTest<Review> {

    @Autowired
    private BaseDao<Review> dao;

    @Autowired
    private ReviewDao reviewDao;

    @Override
    protected BaseDao<Review> getDao() {
        return dao;
    }

    @Override
    protected Review getModel() {
        return new Review();
    }

}
