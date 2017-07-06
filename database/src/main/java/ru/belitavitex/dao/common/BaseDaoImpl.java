package ru.belitavitex.dao.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import ru.belitavitex.entity.BaseEntity;

import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private final Class<T> modelClass;


    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public List<T> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from " + modelClass.getSimpleName(), modelClass)
                .getResultList();
    }

    @Override
    public T findOne(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(modelClass, id);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
