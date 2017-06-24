package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.ArticleDao;
import ru.belitavitex.dao.ReviewDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseServiceImpl;

/**
 * Created by Dzianis on 24.06.2017.
 */
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService{
    private final ReviewDao reviewDao;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    protected BaseDao<Review> getBaseDao() {
        return reviewDao;
    }
}
