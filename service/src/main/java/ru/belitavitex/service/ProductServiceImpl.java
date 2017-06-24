package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.ProductDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.util.List;

/**
 * Created by Dzianis on 24.06.2017.
 */
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    protected BaseDao<Product> getBaseDao() {
        return productDao;
    }

    @Override
    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productDao.findByCategory(category);
    }

    @Override
    public List<Product> getPage(Category category, int maxResults, int firstResult) {
        return productDao.getPage(category, maxResults, firstResult);
    }

    @Override
    public Long getCount() {
        return productDao.getCount();
    }

    @Override
    public Long getCountInCategory(Category category) {
        return productDao.getCountInCategory(category);
    }
}
