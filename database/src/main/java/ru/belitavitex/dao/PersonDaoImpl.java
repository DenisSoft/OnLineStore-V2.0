package ru.belitavitex.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.Person;

import java.util.List;

/**
 * Created by Dzianis on 09.04.2017.
 */
@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

    public List<Person> getPage(int maxResults, int firstResult) {
        Session session = getSessionFactory().getCurrentSession();

        List<Person> result = session.createQuery("from Person", Person.class)
                .setMaxResults(maxResults)
                .setFirstResult(firstResult)
                .getResultList();
        return result;
    }

    public Long getCount() {
        Session session = getSessionFactory().getCurrentSession();

        Long result = session.createQuery("select count(p) from Person p ", Long.class)
                .getSingleResult();
        return result;
    }

    public Person findByEmailAndPassword(String email, String password) {
        Session session = getSessionFactory().getCurrentSession();
        List<Person> result = session.createQuery
                ("select p from Person p where password = :password and email = :email", Person.class)
                .setParameter("password", password)
                .setParameter("email", email)
                .getResultList();
        return result.get(0);
    }
}



