package ru.belitavitex.entity;

import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

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
        return review;
    }

    private Review createReview() {
        Review review = new Review();
        review.setDateCreated(LocalDate.of(2011,03,03));
        review.setArticles(new Article());
        review.setComment("Super");
        review.setPersons(new HashSet<>());
        review.setProducts(new HashSet<>());
        return review;
    }

    @Test
    public void testGetReview() {
        Review review = createReview();
        assertNotNull(review.getDateCreated());
        assertNotNull(review.getArticles());
        assertNotNull(review.getComment());
        assertNotNull(review.getPersons());
        assertNotNull(review.getProducts());
    }
}

