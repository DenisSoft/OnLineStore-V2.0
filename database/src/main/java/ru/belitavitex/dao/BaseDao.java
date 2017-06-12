package ru.belitavitex.dao;

import org.hibernate.Session;
import ru.belitavitex.entity.BaseEntity;
import ru.belitavitex.entity.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */
public abstract class BaseDao<T extends BaseEntity> {

    private Class<T> entityClass;

    public BaseDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public List<T> findAll(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(entityClass);
        criteria.select(criteria.from(entityClass));
        return session.createQuery(criteria).getResultList();
    }

    public T findOne(Session session, Long id) {
        return session.get(entityClass, id);
    }

    public void delete(Session session, T entity){
        session.delete(entity);
    }

    public <S extends T> S save(Session session, S entity){
        session.saveOrUpdate(entity);
        return entity;
    }

}
