package ru.belitavitex.service;

import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseService;

import java.util.List;
import java.util.Set;

/**
 * Created by Dzianis on 24.06.2017.
 */
public interface ProductService extends BaseService<Product> {
    Product findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> findByCategory(Long id);
    List<Product> getPage(Long id, int maxResults, int firstResult);
    Long getCount();
    Long getCountInCategory(Long id);
    void delete(Long id);
    List<Integer> createCatalogOfPages(Long categogyId, int maxResults);
    List<Product> getBestSellers();
    Long getNextImageNumber();
}
