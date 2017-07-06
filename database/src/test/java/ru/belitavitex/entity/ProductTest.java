package ru.belitavitex.entity;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dzianis on 02.06.2017.
 */
public class ProductTest extends BaseTest<Product> {

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    protected Product getModel() {
        return createProduct();
    }

    private Product createProduct() {
        Product product = new Product();
        product.setName("NBA");
        product.setDescription("Super");
        product.setResidue(100);
        product.setPrice(9);
        product.setReviews(new HashSet<>());
        product.setPromotions(new HashSet<>());
        product.setCategory(new Category());
        return product;
    }

    @Test
    public void testGetProduct() {
        Product product = createProduct();
        assertNotNull(product.getName());
        assertNotNull(product.getDescription());
        assertNotNull(product.getResidue());
        assertNotNull(product.getPrice());
        assertNotNull(product.getReviews());
        assertNotNull(product.getPromotions());
        assertNotNull(product.getCategory());
    }
}
