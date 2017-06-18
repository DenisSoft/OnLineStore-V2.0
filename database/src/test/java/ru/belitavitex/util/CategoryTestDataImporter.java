package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.Category;

/**
 * Created by Dzianis on 07.06.2017.
 */

public class CategoryTestDataImporter {

    public static void importTestData(SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();

        Category balm = saveCategory(session, "Бальзамы");
        Category shampoos = saveCategory(session, "Шампуни");
        Category showerGels = saveCategory(session, "Гели для душа");

        session.close();
    }

    private static Category saveCategory(Session session, String name) {
        Category category = new Category(name);
        session.saveOrUpdate(category);
        return category;
    }
}
