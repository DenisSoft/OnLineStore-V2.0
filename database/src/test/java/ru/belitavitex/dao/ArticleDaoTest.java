package ru.belitavitex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ArticleDaoTest extends BaseDaoTest<Article> {

    @Autowired
    private BaseDao<Article> dao;

    @Override
    protected BaseDao<Article> getDao() {
        return dao;
    }

    @Override
    protected Article getModel() {
        return new Article();
    }

}
