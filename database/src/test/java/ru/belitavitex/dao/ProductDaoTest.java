package ru.belitavitex.dao;

import org.junit.Test;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.util.CategoryTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;
import java.util.List;
import static org.junit.Assert.assertEquals;


/**
 * Created by Dzianis on 13.06.2017.
 */

public class ProductDaoTest extends BaseDaoTest<Product>{

    private static final ProductDao PRODUCT_DAO = CONTEXT.getBean(ProductDao.class);
    private static final CategoryDao CATEGORY_DAO = CONTEXT.getBean(CategoryDao.class);
    private BaseDao<Product> dao = PRODUCT_DAO;

    @Override
    protected BaseDao<Product> getDao() {
        return dao;
    }

    @Override
    protected Product getModel() {
        return new Product();
    }

    @Test
    public void testGetPage() {
        ProductTestDataImporter.importTestData(sessionFactory);
        CategoryTestDataImporter.importTestData(sessionFactory);
        Category category = CATEGORY_DAO.findOne(1L);
        List<Product> result = PRODUCT_DAO.getPage(category,5, 0);
        assertEquals(result.size(), 1);
    }

    @Test
    public void testGetCount() {
        ProductTestDataImporter.importTestData(sessionFactory);
        Long result = PRODUCT_DAO.getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testGetCountInCategory() {
        ProductTestDataImporter.importTestData(sessionFactory);
        CategoryTestDataImporter.importTestData(sessionFactory);
        Category category = CATEGORY_DAO.findOne(1L);
        Long result = PRODUCT_DAO.getCountInCategory(category);
        assertEquals(result, 1L, 0.00001);
    }
}
