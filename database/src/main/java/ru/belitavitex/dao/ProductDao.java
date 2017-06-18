package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Product;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class ProductDao extends BaseDao<Product> {

    public ProductDao(){
        super(Product.class);
    }

    public Product findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product result = null;
        try {
            result = session.createQuery
                    ("select p from Product p where name = :name", Product.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (NoResultException e){}
        finally {
            transaction.commit();
            session.close();
            return result;
        }
    }

    public List<Product> getPage(Category category, int maxResults, int firstResult) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Product> result = session.createQuery
                ("select p from Product p where category =:category", Product.class)
                .setParameter("category", category)
                .setMaxResults(maxResults)
                .setFirstResult(firstResult)
                .getResultList();

        transaction.commit();
        session.close();
        return result;
    }

    public Long getCount() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Long result = session.createQuery("select count(p) from Product p ", Long.class)
                .getSingleResult();

        transaction.commit();
        session.close();
        return result;
    }

    public Long getCountInCategory(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Long result = session
                .createQuery("select count(p) from Product p where category =:category", Long.class)
                .setParameter("category", category)
                .getSingleResult();

        transaction.commit();
        session.close();
        return result;
    }
}
