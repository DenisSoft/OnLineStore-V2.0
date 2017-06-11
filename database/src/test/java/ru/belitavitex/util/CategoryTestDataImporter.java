package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.belitavitex.entity.Category;

/**
 * Created by Dzianis on 07.06.2017.
 */
public class CategoryTestDataImporter {
    private static CategoryTestDataImporter INSTANCE;

    private CategoryTestDataImporter() {
    }

    public static CategoryTestDataImporter getInstance() {
        if (INSTANCE == null) {
            synchronized (CategoryTestDataImporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryTestDataImporter();
                }
            }
        }
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        Category balm = saveCategory(session, "Бальзамы");
        Category shampoos = saveCategory(session, "Шампуни");
        Category showerGels = saveCategory(session, "Гели для душа");

        session.close();
    }

    private Category saveCategory(Session session, String name) {
        Category category = new Category(name);
        session.saveOrUpdate(category);
        return category;
    }
}
