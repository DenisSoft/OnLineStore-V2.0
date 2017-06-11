package ru.belitavitex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;

import java.time.LocalDate;

/**
 * Created by Dzianis on 11.06.2017.
 */
public class ArticleTestDataImporter {
    private static ArticleTestDataImporter INSTANCE;

    private ArticleTestDataImporter() {
    }

    public static ArticleTestDataImporter getInstance() {
        if (INSTANCE == null) {
            synchronized (ArticleTestDataImporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ArticleTestDataImporter();
                }
            }
        }
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        Article article = new Article();
        article.setName("История создания");
        article.setText("История косметических предприятий ЗАО «Витэкс» и СП «Белита» " +
                "ООО началась с создания в августе 1988 года на основе республиканской " +
                "базы «Белбытснаб» ЗАО «Белбыткомплект» во главе с Виктором Терещенко.");
        article.setDateCreated(LocalDate.now());
        session.saveOrUpdate(article);

        session.close();
    }
}
