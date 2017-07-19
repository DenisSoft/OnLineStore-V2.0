package ru.belitavitex.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Promotion;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseService;
import ru.belitavitex.util.PersonTestDataImporter;

import static org.junit.Assert.*;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ReviewServiceTest extends BaseServiceTest<Review> {

    @Autowired
    private BaseService<Review> service;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Override
    protected BaseService<Review> getService() {
        return service;
    }

    @Override
    protected Review getModel() {
        return new Review();
    }

    @Test
    public void testModeration() {
        Review review = new Review();
        reviewService.save(review);
        assertFalse(review.isModeration());
        Long id = review.getId();
        reviewService.publish(id);
        Review result = reviewService.findOne(id);
        assertTrue(result.isModeration());
    }

    @Test
    public void testDeliteById() {
        Review review = new Review();
        review.setPerson(new Person());
        reviewService.saveFull(review);
        Long id = review.getId();
        assertNotNull(reviewService.findOne(id));
        reviewService.delete(id);
        assertNull(reviewService.findOne(id));
    }

    @Test
    public void testFindAll() {
        Review review = new Review();
        personTestDataImporter.importTestData();
        Person person = personService.findAll().get(0);
        review.setPerson(person);
        review.setModeration(false);
        reviewService.saveFull(review);
        assertNotNull(reviewService.findAll(false));
        review.setModeration(true);
        reviewService.save(review);
        assertNotNull(reviewService.findAll(true));
    }
}
