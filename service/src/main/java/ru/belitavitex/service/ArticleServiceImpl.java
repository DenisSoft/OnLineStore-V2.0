package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.ArticleDao;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;
import ru.belitavitex.service.common.BaseServiceImpl;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService{

    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    protected BaseDao<Article> getBaseDao() {
        return articleDao;
    }
}
