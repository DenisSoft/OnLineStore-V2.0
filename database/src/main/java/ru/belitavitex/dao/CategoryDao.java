package ru.belitavitex.dao;

import ru.belitavitex.entity.*;

/**
 * Created by Dzianis on 12.06.2017.
 */
public class CategoryDao extends BaseDao<Category>{

    private static CategoryDao INSTANCE = null;

    public static CategoryDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CategoryDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryDao();
                }
            }
        }
        return INSTANCE;
    }

    public CategoryDao(){
        super(Category.class);
    }
}
