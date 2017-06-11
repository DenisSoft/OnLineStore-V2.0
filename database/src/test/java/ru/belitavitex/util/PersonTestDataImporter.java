package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.belitavitex.entity.*;

/**
 * Created by Dzianis on 07.06.2017.
 */
public class PersonTestDataImporter {
    private static PersonTestDataImporter INSTANCE;

    private PersonTestDataImporter() {
    }

    public static PersonTestDataImporter getInstance() {
        if (INSTANCE == null) {
            synchronized (PersonTestDataImporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonTestDataImporter();
                }
            }
        }
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        CategoryTestDataImporter.getInstance().importTestData(sessionFactory);

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

    private Person savePeson(Session session, String firstName, String lastName, String email,
                             String password, Address address, String phone, Groups groups) {
        Person person = new Person(firstName, lastName, email, password, address, phone, groups);
        session.saveOrUpdate(person);
        return person;
    }
}
