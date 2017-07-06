package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.PersonDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Person;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.util.List;

/**
 * Created by Dzianis on 13.04.2017.
 */

@Service
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService{
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected BaseDao<Person> getBaseDao() {
        return personDao;
    }

    public void save(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
         personDao.save(person);
    }

    @Override
    public List<Person> getPage(int maxResults, int firstResult) {
        return personDao.getPage(maxResults, firstResult);
    }

    @Override
    public Long getCount() {
        return personDao.getCount();
    }

    @Override
    public Person findByEmail(String email) {
        return personDao.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        Person person = new Person();
        person.setId(id);
        personDao.delete(person);
    }
}
