package ru.belitavitex.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.belitavitex.dao.PersonDao;
import ru.belitavitex.entity.Person;

import java.util.List;

import static ru.belitavitex.dao.BaseDao.SESSION_FACTORY;

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
        Session session = SESSION_FACTORY.openSession();
        List<Person> personList = PersonDao.getInstance().findAll();
        session.close();
        return personList;
    }
}
