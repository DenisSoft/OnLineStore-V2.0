package ru.belitavitex.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.util.CategoryTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static ru.belitavitex.dao.BaseDao.SESSION_FACTORY;

/**
 * Created by Dzianis on 13.06.2017.
 */
public class ProductDaoTest {

    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(ProductDaoTest.class);

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        ProductDao.getInstance();
        ProductTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
        CategoryTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testFindAll() {
        List<Product> result = ProductDao.getInstance().findAll();
        assertEquals(result.size(), 3);
    }

    @Test
    public void testFindOne() {
        Product result = ProductDao.getInstance().findOne(2L);
        assertEquals(result.getName(), "SPA – шампунь Минеральный");
    }

    @Test
    public void testDelete() {
        Product Product = ProductDao.getInstance().findOne(1L);
        ProductDao.getInstance().delete(Product);
        Product result = ProductDao.getInstance().findOne(1L);
        assertEquals(result, null);
    }

    @Test
    public void testSave() {

        Category category = CategoryDao.getInstance().findOne(2L);
        Product Product = new Product("Шампунь «Лимон-лайм»",
                "Шампунь предназначен для бережного ухода за всеми типами волос.",
                99, 100, category);
        ProductDao.getInstance().save(Product);
        Product result = ProductDao.getInstance().findByName("Шампунь «Лимон-лайм»");
        assertEquals(result.getPrice(), 99);
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
