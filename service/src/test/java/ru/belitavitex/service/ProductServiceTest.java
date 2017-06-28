package ru.belitavitex.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.BaseServiceTest;
import ru.belitavitex.service.common.BaseService;
import ru.belitavitex.util.ProductTestDataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Dzianis on 13.06.2017.
 */

public class ProductServiceTest extends BaseServiceTest<Product> {

    @Autowired
    private BaseService<Product> service;

    @Override
    protected BaseService<Product> getService() {
        return service;
    }

    @Override
    protected Product getModel() {
        return new Product();
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductTestDataImporter productTestDataImporter;


    @Test
    public void testFindByName() {
        productTestDataImporter.importTestData();
        Product result = productService.findByName("Бальзам для жирных волос");
        assertNotNull(result);
    }

    @Test
    public void testFindByCategory() {
        productTestDataImporter.importTestData();
        Category category = categoryService.findAll().get(0);
        List<Product> result = productService.findByCategory(category);
        assertEquals(result.size(), 3);
    }

    @Test
    public void testGetPage() {
        productTestDataImporter.importTestData();
        Category category = categoryService.findAll().get(0);
        List<Product> result = productService.getPage(category,5, 0);
        assertEquals(result.size(), 3);
    }

    @Test
    public void testGetCount() {
        productTestDataImporter.importTestData();
        Long result = productService.getCount();
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testGetCountInCategory() {
        productTestDataImporter.importTestData();
        Category category = categoryService.findAll().get(0);
        Long result = productService.getCountInCategory(category);
        assertEquals(result, 3L, 0.00001);
    }
}
