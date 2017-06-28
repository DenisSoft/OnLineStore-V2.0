package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;
import ru.belitavitex.service.common.BaseService;


/**
 * Created by Dzianis on 14.06.2017.
 */

public class CategoryServiceTest extends BaseServiceTest<Category>{

    @Autowired
    private BaseService<Category> service;

    @Override
    protected BaseService<Category> getService() {
        return service;
    }

    @Override
    protected Category getModel() {
        return new Category();
    }
}
