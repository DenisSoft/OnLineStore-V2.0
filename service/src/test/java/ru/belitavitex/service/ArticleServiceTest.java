package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.service.BaseServiceTest;
import ru.belitavitex.service.common.BaseService;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class ArticleServiceTest extends BaseServiceTest<Article> {

    @Autowired
    private BaseService<Article> service;

    @Override
    protected BaseService<Article> getService() {
        return service;
    }

    @Override
    protected Article getModel() {
        return new Article();
    }

}
