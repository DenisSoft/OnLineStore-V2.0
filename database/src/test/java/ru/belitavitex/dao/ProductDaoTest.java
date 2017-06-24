package ru.belitavitex.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.util.ProductTestDataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Dzianis on 13.06.2017.
 */

public class ProductDaoTest extends BaseDaoTest<Product>{
    @Autowired
    private BaseDao<Product> dao;

    @Override
    protected BaseDao<Product> getDao() {
        return dao;
    }

    @Override
    protected Product getModel() {
        return new Product();
    }

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductTestDataImporter productTestDataImporter;


    @Test
    public void testFindByName() {
        productTestDataImporter.importTestData();
        Product result = productDao.findByName("Бальзам для жирных волос");
        assertNotNull(result);
    }

    @Test
    public void testFindByCategory() {
        productTestDataImporter.importTestData();
        Category category = categoryDao.findAll().get(0);
        List<Product> result = productDao.findByCategory(category);
        assertEquals(result.size(), 3);
    }

    @Test
    public void testGetPage() {
        productTestDataImporter.importTestData();
        Category category = categoryDao.findAll().get(0);
        List<Product> result = productDao.getPage(category,5, 0);
        assertEquals(result.size(), 3);
    }

    @Test
    public void testGetCount() {
        productTestDataImporter.importTestData();
        Long result = productDao.getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testGetCountInCategory() {
        productTestDataImporter.importTestData();
        Category category = categoryDao.findAll().get(0);
        Long result = productDao.getCountInCategory(category);
        assertEquals(result, 3L, 0.00001);
    }
}
