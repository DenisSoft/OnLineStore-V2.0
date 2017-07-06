package ru.belitavitex.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.belitavitex.config.TestServiceConfig;
import ru.belitavitex.entity.BaseEntity;
import ru.belitavitex.service.common.BaseService;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dzianis on 17.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestServiceConfig.class)
@Transactional
public abstract class BaseServiceTest<T extends BaseEntity> {

    protected abstract BaseService<T> getService();
    protected abstract T getModel();

    @Test
    public void testFindById() {
        T model = getModel();
        getService().save(model);
        Long id = model.getId();
        T entity = getService().findOne(id);
        assertNotNull(entity);
    }

    @Test
    public void testDelete() {
        T model = getModel();
        getService().save(model);
        Long id = model.getId();
        getService().delete(model);
        T entity = getService().findOne(id);
        assertNull(entity);
    }

    @Test
    public void testfindAll() {
        List<T> entity = getService().findAll();
        assertEquals(entity.size(), 0);
        T model1 = getModel();
        getService().save(model1);
        T model2 = getModel();
        getService().save(model2);
        entity = getService().findAll();
        assertEquals(entity.size(), 2);
    }

    @Test
    public void testSave() {
        List<T> entity = getService().findAll();
        assertEquals(entity.size(), 0);
        T model = getModel();
        getService().save(model);
        entity = getService().findAll();
        assertEquals(entity.size(), 1);
    }

}
