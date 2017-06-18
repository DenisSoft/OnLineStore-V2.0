package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.*;

import java.util.List;

/**
 * Created by Dzianis on 07.06.2017.
 */

public class PersonTestDataImporter {

    public static void importTestData(SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();

        Person muxim = savePeson(session, "Максим", "Долгорукий",
                "dolgorukiy@bk.ru", "1", new Address("Беларусь",
                        "Минск", "Голодеда", 5, 1, 75, "220066"),
                "+375296849031", Groups.USER);
        Person egor = savePeson(session, "Егор", "Миронов",
                "mironov@bk.ru", "2", new Address("Беларусь",
                        "Минск", "Мирошниченко", 10, 1, 148, "220033"),
                "+375296849032", Groups.USER);
        Person elena = savePeson(session, "Елена", "Хмель",
                "hemel@bk.ru", "3", new Address("Беларусь",
                        "Минск", "Рокоссовского", 4, 4, 435, "220047"),
                "+375296849033", Groups.USER);

        session.close();
    }

    private static Person savePeson(Session session, String firstName, String lastName, String email,
                                    String password, Address address, String phone, Groups groups) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPassword(password);
        person.setAddress(address);
        person.setPhone(phone);
        person.setGroups(groups);

        session.saveOrUpdate(person);
        return person;
    }
}
