package ru.belitavitex.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.belitavitex.config.TestConfig;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.BaseEntity;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dzianis on 17.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public abstract class BaseDaoTest<T extends BaseEntity> {

    protected abstract BaseDao<T> getDao();
    protected abstract T getModel();

    @Test
    public void testFindById() {
        T model = getModel();
        Long id = getDao().save(model);

        T entity = getDao().findOne(id);
        assertNotNull(entity);
    }

    @Test
    public void testDelete() {
        T model = getModel();
        getDao().save(model);

        getDao().delete(model);

        T entity = getDao().findOne(1L);
        assertNull(entity);
    }

    @Test
    public void testfindAll() {
        List<T> entity = getDao().findAll();
        assertEquals(entity.size(), 0);

        T model1 = getModel();
        getDao().save(model1);
        T model2 = getModel();
        getDao().save(model2);

        entity = getDao().findAll();
        assertEquals(entity.size(), 2);
    }

    @Test
    public void testSave() {
        List<T> entity = getDao().findAll();
        assertEquals(entity.size(), 0);

        T model = getModel();
        getDao().save(model);

        entity = getDao().findAll();
        assertEquals(entity.size(), 1);
    }

    @After
    public void finish() {
    }
}
