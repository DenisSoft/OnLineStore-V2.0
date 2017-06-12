package ru.belitavitex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import ru.belitavitex.entity.Person;

import java.util.List;

/**
 * Created by Dzianis on 09.04.2017.
 */
public class PersonDao extends BaseDao<Person>{

    private static final Object LOCK = new Object();
    private static PersonDao INSTANCE = null;

    public static PersonDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
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

    public static List<Person> getPage(Session session, int maxResults, int firstResult) {
        return session.createQuery("from Person", Person.class)
                .setMaxResults(maxResults)
                .setFirstResult(firstResult)
                .getResultList();
    }

    public static Long getCount(Session session) {
        return session.createQuery("select count(p) from Person p ", Long.class)
                .getSingleResult();
    }

    public Person findByEmailAndPassword(Session session, String email, String password) {
        return session.createQuery("select p from Person p where password = :password and email = :email", Person.class)
                .setParameter("password", password)
                .setParameter("email", email)
                .getSingleResult();
    }

    public static Session getSession(){
            return new Configuration().configure().buildSessionFactory().openSession();
    }
}


