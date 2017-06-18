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

    public static List<Person> getAll() {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.findAll();
        return personList;
    }
}
