package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;

/**
 * Created by Dzianis on 07.06.2017.
 */

public class ProductTestDataImporter {

    public static void importTestData(SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();
        CategoryTestDataImporter.importTestData(sessionFactory);

        Product balm = saveProduct(session, "Бальзам для жирных волос",
                "Легчайшая формула бальзама, не содержащая масел, " +
                 "специально разработана для максимально эффективного ухода " +
                 "за жирными и быстро загрязняющимися волосами.",
                6, 100, session.get(Category.class,1L));
        Product shampoos = saveProduct(session, "SPA – шампунь Минеральный",
                "Шампунь прекрасно очищает, не вымывая " +
                "естественную защиту волос, питает кожу головы. Помогает " +
                "оградить волосы от вредного воздействия окружающей среды.",
                5, 100, session.get(Category.class,2L));
        Product showerGels = saveProduct(session, "ГЕЛЬ ДЛЯ ДУША АКВА-ДРЕНАЖ",
                "Инновационная формула геля для душа обеспечивает " +
                 "эффективное очищение кожи и подготовку к антицеллюлитным " +
                 "процедурам.",
                9, 100, session.get(Category.class,3L));

        session.close();
    }

    private static Product saveProduct(Session session, String name, String description, int price,
                                       int residue, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setResidue(residue);
        product.setCategory(category);
        session.saveOrUpdate(product);
        return product;
    }
}
