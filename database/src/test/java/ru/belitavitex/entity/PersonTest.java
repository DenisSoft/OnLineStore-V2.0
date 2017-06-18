package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

import java.util.Set;

/**
 * Created by Dzianis on 01.06.2017.
 */
public class PersonTest extends BaseTest<Person> {

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    protected Person getModel() {
        Person person = new Person();
        person.setGroups(Groups.USER);
        person.setPhone("=375296849032");
        person.setAddress(new Address());
        person.setPassword("1");
        person.setEmail("bf@bk.ru");
        person.setLastName("Bodrov");
        person.setFirstName("Danila");
        return new Person();
    }
}
