package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.util.ArticleTestDataImporter;
import ru.belitavitex.util.CategoryTestDataImporter;
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 02.06.2017.
 */
public class ReviewTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        PersonTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
        ProductTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
        ArticleTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testSaveReviewForProduct() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Review review = new Review();
        review.setComment("Шампунь отстой");
        review.setDateCreated(LocalDate.now());
        review.getPersons().add(session.find(Person.class, 3L));
        review.getProducts().add(session.find(Product.class, 2L));
        Long id = (Long)session.save(review);

        Review savedReview = session.find(Review.class, id);
        Assert.assertEquals(savedReview.getComment(), "Шампунь отстой");

        transaction.commit();
        session.close();
    }

    @Test
    public void testSaveReviewForArticle() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Review review = new Review();
        review.setComment("Супер предприятие!");
        review.setDateCreated(LocalDate.now());
        review.getPersons().add(session.find(Person.class, 2L));
        review.setArticles(session.find(Article.class, 1L));
        Long id = (Long)session.save(review);

        Review savedReview = session.find(Review.class, id);
        Assert.assertEquals(savedReview.getComment(), "Супер предприятие!");

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}

