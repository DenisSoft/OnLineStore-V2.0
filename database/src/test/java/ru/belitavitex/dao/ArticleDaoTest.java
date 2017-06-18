package ru.belitavitex.dao;

import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ArticleDaoTest extends BaseDaoTest<Article>{

    private BaseDao<Article> dao = CONTEXT.getBean(ArticleDao.class);

    @Override
    protected BaseDao<Article> getDao() {
        return dao;
    }

    @Override
    protected Article getModel() {
        return new Article();
    }
}
