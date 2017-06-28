package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Promotion;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseService;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ReviewServiceTest extends BaseServiceTest<Review> {

    @Autowired
    private BaseService<Review> service;

    @Override
    protected BaseService<Review> getService() {
        return service;
    }

    @Override
    protected Review getModel() {
        return new Review();
    }

}
