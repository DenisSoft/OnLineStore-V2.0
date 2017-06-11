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
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

import java.time.LocalDate;

/**
 * Created by Dzianis on 08.06.2017.
 */
public class PromotionTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        ProductTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testSavePromotion() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Promotion promotion = new Promotion();
        promotion.setDateStart(LocalDate.of(2017, 8, 4));
        promotion.setDateEnd(LocalDate.of(2017, 8, 5));
        promotion.setName("Черная пятница! Скидки 30%!");
        promotion.getProducts().add(session.find(Product.class, 1L));
        promotion.getProducts().add(session.find(Product.class, 2L));
        promotion.getProducts().add(session.find(Product.class, 3L));
        promotion.setDiscount(30);
        Long id = (Long) session.save(promotion);

        Promotion savePromotion = session.find(Promotion.class, id);
        Assert.assertEquals(savePromotion.getName(), "Черная пятница! Скидки 30%!");

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
