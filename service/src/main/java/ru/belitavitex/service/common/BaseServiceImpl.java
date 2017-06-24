package ru.belitavitex.service.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.BaseEntity;

import java.util.List;

/**
 * Created by Dzianis on 12.06.2017.
 */

@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected abstract BaseDao<T> getBaseDao();

    @Override
    public void save(T entity) {
        getBaseDao().save(entity);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public T findOne(Long id) {
        return (T) getBaseDao().findOne(id);
    }

    @Override
    public void delete(T entity) {
        getBaseDao().delete(entity);
    }

}
