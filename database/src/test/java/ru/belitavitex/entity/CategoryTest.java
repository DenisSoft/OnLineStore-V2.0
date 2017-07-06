package ru.belitavitex.entity;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.HashSet;

/**
 * Created by Dzianis on 01.06.2017.
 */
public class CategoryTest extends BaseTest<Category> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected Category getModel() {
        return createCategory();
    }

    private Category createCategory() {
        Category category = new Category();
        category.setName("Shampoos");
        category.setProducts(new HashSet<>());
        return category;
    }

    @Test
    public void testGetCategory() {
        Category category = createCategory();
        assertNotNull(category.getName());
        assertNotNull(category.getProducts());
    }

}
