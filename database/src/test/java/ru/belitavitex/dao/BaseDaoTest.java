package ru.belitavitex.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.belitavitex.Config;
import ru.belitavitex.entity.BaseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Dzianis on 17.06.2017.
 */
public abstract class BaseDaoTest<T extends BaseEntity> {

    public static final AnnotationConfigApplicationContext CONTEXT
            = new AnnotationConfigApplicationContext(Config.class);
    public static SessionFactory sessionFactory;

    protected abstract BaseDao<T> getDao();

    protected abstract T getModel();

    @Before
    public void init() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testFindById() {
        T model = getModel();
        Long id = getDao().save(model).getId();

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
        sessionFactory.close();
    }
}
