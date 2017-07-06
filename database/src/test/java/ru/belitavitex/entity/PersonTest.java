package ru.belitavitex.entity;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

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
        return createPerson();
    }

    private Person createPerson() {
        Person person = new Person();
        person.setGroups(Groups.USER);
        person.setPhone("+375296849032");
        person.setAddress(new Address());
        person.setPassword("1");
        person.setEmail("bf@bk.ru");
        person.setLastName("Bodrov");
        person.setFirstName("Danila");
        person.setReviews(new HashSet<>());
        return person;
    }

    @Test
    public void testGetPerson() {
        Person person = createPerson();
        assertNotNull(person.getGroups());
        assertNotNull(person.getPhone());
        assertNotNull(person.getAddress());
        assertNotNull(person.getPassword());
        assertNotNull(person.getEmail());
        assertNotNull(person.getLastName());
        assertNotNull(person.getFirstName());
        assertNotNull(person.getReviews());
        assertNotNull(person.fullName());
    }
}
