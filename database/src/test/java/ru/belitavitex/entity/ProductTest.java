package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.util.CategoryTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

/**
 * Created by Dzianis on 02.06.2017.
 */
public class ProductTest  extends BaseTest<Product>{

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    protected Product getModel() {
        Product product = new Product();
        product.setName("NBA");
        product.setDescription("Super");
        product.setResidue(100);
        product.setPrice(9);
        return product;
    }
}
