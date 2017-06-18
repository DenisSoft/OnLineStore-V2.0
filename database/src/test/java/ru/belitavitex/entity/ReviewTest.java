package ru.belitavitex.entity;

import java.time.LocalDate;

/**
 * Created by Dzianis on 02.06.2017.
 */
public class ReviewTest extends BaseTest<Review> {

    @Override
    protected Class<Review> getEntityClass() {
        return Review.class;
    }

    @Override
    protected Review getModel() {
        Review review = new Review();
        review.setDateCreated(LocalDate.of(2011,03,03));
        review.setArticles(new Article());
        review.setComment("Super");
        return new Review();
    }
}

