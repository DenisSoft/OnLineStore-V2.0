package ru.belitavitex.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.PersonTest;
import ru.belitavitex.util.CategoryTestDataImporter;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.belitavitex.dao.BaseDao.SESSION_FACTORY;

/**
 * Created by Dzianis on 14.06.2017.
 */
public class CategoryDaoTest {
    private static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PersonTest.class);

    @BeforeClass
    public static void init() {

        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        CategoryDao.getInstance();
        CategoryTestDataImporter.getInstance().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testFindAll() {
        List<Category> result = CategoryDao.getInstance().findAll();
        assertEquals(result.size(), 3);
    }

    @Test
    public void testFindOne() {
        Category result = CategoryDao.getInstance().findOne(2L);
        assertEquals(result.getName(), "Шампуни");
    }

    @Test
    public void testDelete() {
        Category Category = CategoryDao.getInstance().findOne(1L);
        CategoryDao.getInstance().delete(Category);
        Category result = CategoryDao.getInstance().findOne(1L);
        assertEquals(result, null);
    }

    @Test
    public void testSave() {

        Category Category = new Category("Спреи, тоники, лосьоны");
        CategoryDao.getInstance().save(Category);
        Category result = CategoryDao.getInstance().findOne(4L);
        assertEquals(result.getName(), "Спреи, тоники, лосьоны");
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
