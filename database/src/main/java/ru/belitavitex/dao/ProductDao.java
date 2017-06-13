package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Product;

import javax.persistence.NoResultException;

/**
 * Created by Dzianis on 12.06.2017.
 */
public class ProductDao extends BaseDao<Product> {

    private static ProductDao INSTANCE = null;

    public static ProductDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ProductDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductDao();
                }
            }
        }
        return INSTANCE;
    }

    public ProductDao(){
        super(Product.class);
    }

    public Product findByName(String name) {
        Session session = SESSION_FACTORY.openSession();
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
}
