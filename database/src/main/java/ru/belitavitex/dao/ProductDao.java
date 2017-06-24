package ru.belitavitex.dao;

import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;

import java.util.List;

/**
 * Created by Dzianis on 22.06.2017.
 */
public interface ProductDao extends BaseDao<Product> {
    Product findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> getPage(Category category, int maxResults, int firstResult);
    Long getCount();
    Long getCountInCategory(Category category);
}
