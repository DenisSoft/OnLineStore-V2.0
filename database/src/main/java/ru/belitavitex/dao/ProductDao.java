package ru.belitavitex.dao;

import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Product;

/**
 * Created by Dzianis on 12.06.2017.
 */
public class ProductDao extends BaseDao<Product> {

    public ProductDao(){
        super(Product.class);
    }
}
