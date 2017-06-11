package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;

/**
 * Created by Dzianis on 07.06.2017.
 */
public class ProductTestDataImporter {
    private static ProductTestDataImporter INSTANCE;

    private ProductTestDataImporter() {
    }

    public static ProductTestDataImporter getInstance() {
        if (INSTANCE == null) {
            synchronized (ProductTestDataImporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductTestDataImporter();
                }
            }
        }
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        CategoryTestDataImporter.getInstance().importTestData(sessionFactory);

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

    private Product saveProduct(Session session, String name, String description, int price,
                                int residue, Category category) {
        Product product = new Product(name, description, price, residue, category);
        session.saveOrUpdate(product);
        return product;
    }
}
