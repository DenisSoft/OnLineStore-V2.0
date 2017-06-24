package ru.belitavitex.entity;

import java.util.HashSet;

/**
 * Created by Dzianis on 01.06.2017.
 */
public class CategoryTest extends BaseTest<Category>{

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected Category getModel() {
        Category category = new Category();
        category.setName("Shampoos");
        category.setProducts(new HashSet<>());
        return category;
    }
}
