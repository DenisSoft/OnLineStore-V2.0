package ru.belitavitex.service;

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
        return PersonDao.getInstance().getAll();
    }
}
