package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.ArticleDao;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    protected BaseDao<Article> getBaseDao() {
        return articleDao;
    }

    @Override
    public Article findOne(Long id){
        Article article = articleDao.findOne(id);
        if (article != null){
            article.setReviews(article.getReviews()
                    .stream()
                    .filter(Review::isModeration)
                    .collect(Collectors.toCollection(HashSet::new)));
        }
        return article;
    }

    @Override
    public void delete(Long id) {
        Article article = articleDao.findOne(id);
        articleDao.delete(article);
    }
}
