package ru.belitavitex.service.common;

import ru.belitavitex.entity.BaseEntity;

import java.util.List;

/**
 * Created by Dzianis on 22.06.2017.
 */
public interface BaseService<T extends BaseEntity> {

    Long save(T entity);
    List<T> findAll();
    void delete(T entity);
    T findOne(Long id);

}
