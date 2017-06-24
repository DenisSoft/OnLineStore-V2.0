package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;

import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao  {

    public Product findByName(String name) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery ("select p from Product p where name = :name", Product.class)
                .setParameter("name", name)
                .getResultList()
                .get(0);
    }

    public List<Product> findByCategory(Category category) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery ("select p from Product p where category = :category", Product.class)
                .setParameter("category", category)
                .getResultList();
    }

    public List<Product> getPage(Category category, int maxResults, int firstResult) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("select p from Product p where category =:category", Product.class)
                .setParameter("category", category)
                .setMaxResults(maxResults)
                .setFirstResult(firstResult)
                .getResultList();
    }

    public Long getCount() {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("select count(p) from Product p ", Long.class)
                .getSingleResult();
    }

    public Long getCountInCategory(Category category) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("select count(p) from Product p where category =:category", Long.class)
                .setParameter("category", category)
                .getSingleResult();
    }
}
