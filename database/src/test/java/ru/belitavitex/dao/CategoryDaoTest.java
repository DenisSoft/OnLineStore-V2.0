package ru.belitavitex.dao;

import ru.belitavitex.entity.Category;




/**
 * Created by Dzianis on 14.06.2017.
 */

public class CategoryDaoTest extends BaseDaoTest<Category>{

    private BaseDao<Category> dao = CONTEXT.getBean(CategoryDao.class);

    @Override
    protected BaseDao<Category> getDao() {
        return dao;
    }

    @Override
    protected Category getModel() {
        return new Category();
    }
}
