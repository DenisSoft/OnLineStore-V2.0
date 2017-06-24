package ru.belitavitex.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.belitavitex.config.TestConfig;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dzianis on 17.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public abstract class BaseTest<T extends BaseEntity> {

    protected abstract Class<T> getEntityClass();
    protected abstract T getModel();

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    public void testEntity() {
        Session session = sessionFactory.getCurrentSession();
        T entity = getModel();
        Long id = (Long) session.save(entity);

        T result = session.get(getEntityClass(), id);
        assertNotNull(result);
    }
}
