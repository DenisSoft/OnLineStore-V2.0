package ru.belitavitex.service;

import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.common.BaseService;

import java.util.List;

/**
 * Created by Dzianis on 24.06.2017.
 */
public interface ProductService extends BaseService<Product> {
    Product findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> getPage(Category category, int maxResults, int firstResult);
    Long getCount();
    Long getCountInCategory(Category category);
}
