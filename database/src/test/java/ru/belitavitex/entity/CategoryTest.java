package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.belitavitex.Config;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.util.CategoryTestDataImporter;

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
