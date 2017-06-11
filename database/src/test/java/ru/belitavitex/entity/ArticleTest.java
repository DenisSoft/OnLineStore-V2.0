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

import java.time.LocalDate;

/**
 * Created by Dzianis on 11.06.2017.
 */
public class ArticleTest {
    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        ArticleTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testSaveArticle() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Article savedArticle = session.find(Article.class, 1L);
        Assert.assertEquals(savedArticle.getName(), "История создания");

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
