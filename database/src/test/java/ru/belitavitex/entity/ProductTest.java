package ru.belitavitex.entity;

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
