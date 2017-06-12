package ru.belitavitex.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.belitavitex.dao.PersonDao;
import ru.belitavitex.entity.Person;

import java.util.List;

/**
 * Created by Dzianis on 13.04.2017.
 */
public class PersonService {
    private static final Object LOCK = new Object();
    private static PersonService INSTANCE = null;

    public static PersonService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonService();
                }
            }
        }
        return INSTANCE;
    }

    public static List<Person> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Person> personList = PersonDao.getInstance().findAll(session);
        session.close();
        sessionFactory.close();
        return personList;
    }
}
