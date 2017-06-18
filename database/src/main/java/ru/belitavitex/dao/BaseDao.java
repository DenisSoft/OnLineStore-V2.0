package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.BaseEntity;
import ru.belitavitex.entity.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public abstract class BaseDao<T extends BaseEntity> {

    @Autowired
    SessionFactory sessionFactory;

    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Class<T> entityClass;

    public BaseDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if(entity != null){
            session.delete(entity);
        }

        transaction.commit();
        session.close();
    }

    public <S extends T> S save(S entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(entity);
        T result = entity;

        transaction.commit();
        session.close();
        return entity;
    }
}
