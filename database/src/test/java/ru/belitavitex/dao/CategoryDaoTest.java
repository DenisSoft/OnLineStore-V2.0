package ru.belitavitex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;




/**
 * Created by Dzianis on 14.06.2017.
 */

public class CategoryDaoTest extends BaseDaoTest<Category>{

    @Autowired
    private BaseDao<Category> dao;

    @Override
    protected BaseDao<Category> getDao() {
        return dao;
    }

    @Override
    protected Category getModel() {
        return new Category();
    }
}
