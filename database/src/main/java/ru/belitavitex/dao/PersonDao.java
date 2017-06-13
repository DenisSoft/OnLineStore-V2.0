package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import ru.belitavitex.entity.Person;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Dzianis on 09.04.2017.
 */
public class PersonDao extends BaseDao<Person>{

    private static PersonDao INSTANCE = null;

    public static PersonDao getInstance() {
        if (INSTANCE == null) {
            synchronized (PersonDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonDao();
                }
            }
        }
        return INSTANCE;
    }

    public PersonDao(){
        super(Person.class);
    }

    public List<Person> getPage(int maxResults, int firstResult) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Person> result = session.createQuery("from Person", Person.class)
                .setMaxResults(maxResults)
                .setFirstResult(firstResult)
                .getResultList();

        transaction.commit();
        session.close();
        return result;
    }

    public Long getCount() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Long result = session.createQuery("select count(p) from Person p ", Long.class)
                .getSingleResult();

        transaction.commit();
        session.close();
        return result;
    }

    public Person findByEmailAndPassword(String email, String password) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Person result = null;
        try {
            result = session.createQuery
                    ("select p from Person p where password = :password and email = :email", Person.class)
                    .setParameter("password", password)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (NoResultException e){}
        finally {
            transaction.commit();
            session.close();
            return result;
        }
    }
}


