package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.belitavitex.entity.BaseEntity;
import ru.belitavitex.entity.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */
public abstract class BaseDao<T extends BaseEntity> {

    public static final SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass;

    public BaseDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public List<T> findAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(entityClass);
        criteria.select(criteria.from(entityClass));
        List<T> result = session.createQuery(criteria).getResultList();

        transaction.commit();
        session.close();
        return result;
    }

    public T findOne(Long id) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        T result = null;
        try {
            result = session.get(entityClass, id);
        }catch (IllegalArgumentException e){}
        finally {
            transaction.commit();
            session.close();
            return result;
        }


    }

    public void delete(T entity){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        if(entity != null){
            session.delete(entity);
        }

        transaction.commit();
        session.close();
    }

    public <S extends T> S save(S entity){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(entity);
        T result = entity;

        transaction.commit();
        session.close();
        return entity;
    }
}
