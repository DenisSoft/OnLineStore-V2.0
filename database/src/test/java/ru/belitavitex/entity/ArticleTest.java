package ru.belitavitex.entity;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dzianis on 11.06.2017.
 */
public class ArticleTest extends BaseTest<Article> {

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    @Override
    protected Article getModel() {
        return createArticle();
    }

    private Article createArticle() {
        Article article = new Article();
        article.setName("About us");
        article.setDateCreated(LocalDate.now());
        article.setText("Excellent factory");
        article.setReviews(new HashSet<>());
        article.setUpdateTime(LocalDateTime.now());
        return article;
    }

    @Test
    public void testGetArticle() {
        Article article = createArticle();
        assertNotNull(article.getName());
        assertNotNull(article.getText());
        assertNotNull(article.getDateCreated());
        assertNotNull(article.getReviews());
        assertNotNull(article.getUpdateTime());
    }
}
