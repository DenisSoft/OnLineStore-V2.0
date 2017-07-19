package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.OrderItemDao;
import ru.belitavitex.dao.ProductDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

    private final ProductDao productDao;

    private final OrderItemDao orderItemDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, OrderItemDao orderItemDao) {
        this.productDao = productDao;
        this.orderItemDao = orderItemDao;
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
    public List<Product> findByCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        return productDao.findByCategory(category);
    }

    @Override
    public List<Product> getPage(Long id, int maxResults, int firstResult) {
        Category category = new Category();
        category.setId(id);
        return productDao.getPage(category, maxResults, firstResult);
    }

    @Override
    public Long getCount() {
        return productDao.getCount();
    }

    @Override
    public Long getCountInCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        return productDao.getCountInCategory(category);
    }

    @Override
    public void delete(Long id) {
        Product product = productDao.findOne(id);
        productDao.delete(product);
    }

    @Override
    public List<Integer> createCatalogOfPages(Long categogyId, int maxResults) {
        ArrayList<Integer> pages = new ArrayList<>();
        Long countPages = getCountInCategory(categogyId) / maxResults;
        countPages = countPages % 10 == 0 ? countPages : countPages + 1;
        countPages = countPages == 0 ? 1 : countPages;
        for (int i = 1; i <= countPages; i++) {
            pages.add(i);
        }
        return pages;
    }

    public List<Product> getBestSellers(){
        return orderItemDao.getBestSellers();
    }

    @Override
    public Long getNextImageNumber() {
        List<Product> productAll = productDao.findAll();
        int lostNumber = productAll.size()-1;
        return productAll.get(lostNumber).getId()+1;
    }

    @Override
    public Product findOne(Long id){
        Product product = productDao.findOne(id);
        if (product != null){
            product.setReviews(product.getReviews()
                    .stream()
                    .filter(Review::isModeration)
                    .collect(Collectors.toCollection(HashSet::new)));
        }
        return product;
    }
}
