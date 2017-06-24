package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.ArticleDao;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.CategoryDaoImpl;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.util.List;

/**
 * Created by Dzianis on 22.06.2017.
 */
@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category>  implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    protected BaseDao<Category> getBaseDao() {
        return categoryDao;
    }
}
