package ru.belitavitex.entity;

import java.time.LocalDate;

/**
 * Created by Dzianis on 11.06.2017.
 */
public class ArticleTest extends BaseTest<Article>{

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    @Override
    protected Article getModel() {
        Article article = new Article();
        article.setName("About us");
        article.setDateCreated(LocalDate.now());
        article.setText("Excellent factory");
        return article;
    }
}
