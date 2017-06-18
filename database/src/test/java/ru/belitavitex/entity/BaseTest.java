package ru.belitavitex.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.belitavitex.Config;
import ru.belitavitex.dao.BaseDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dzianis on 17.06.2017.
 */
public abstract class BaseTest<T extends BaseEntity> {
    private static final SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();
    protected abstract Class<T> getEntityClass();
    protected abstract T getModel();

    @Test
    public void testEntity() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        T entity = getModel();
        Long id = (Long) session.save(entity);

        T result = session.get(getEntityClass(), id);
        assertNotNull(result);

        session.delete(result);

        transaction.commit();
        session.close();
    }
}
