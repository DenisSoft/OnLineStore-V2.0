package ru.belitavitex.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderItem;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.BaseServiceTest;
import ru.belitavitex.service.common.BaseService;
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


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
    private CustomerOrderService customerOrderService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductTestDataImporter productTestDataImporter;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Autowired
    private PersonService personService;


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
        result = productService.findByCategory(category.getId());
        assertEquals(result.size(), 3);
    }

    @Test
    public void testGetPage() {
        Long idCategory = productTestDataImporter.importTestData();
        List<Product> result = productService.getPage(idCategory, 6,0);
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
        Long idCategory = productTestDataImporter.importTestData();
        Category category = categoryService.findAll().get(0);
        Long result = productService.getCountInCategory(idCategory);
        assertEquals(result, 3L, 0.00001);
    }

    @Test
    public void testDeliteById() {
        productTestDataImporter.importTestData();
        Product product = productService.findAll().get(0);
        Long id = product.getId();
        productService.delete(id);
        assertNull(productService.findOne(id));
    }

    @Test
    public void testCreateCatalogOfPages(){
        Long idCategory = productTestDataImporter.importTestData();
        List<Integer> catalogOfPages = productService.createCatalogOfPages(idCategory, 3);
        assertNotNull(catalogOfPages);
    }

    @Test
    public void testgetBestSellers(){
        productTestDataImporter.importTestData();
        personTestDataImporter.importTestData();
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(productService.findAll().get(0));
        orderItem.setQuantity(5);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.getOrderItems().add(orderItem);
        customerOrder.setPerson(personService.findAll().get(0));
        customerOrderService.save(customerOrder);
        List<Product> bestSellers = productService.getBestSellers();
        assertNotNull(bestSellers);
    }
}
