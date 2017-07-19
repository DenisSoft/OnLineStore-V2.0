package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.CategoryDao;
import ru.belitavitex.dao.ProductDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.service.common.BaseServiceImpl;

/**
 * Created by Dzianis on 22.06.2017.
 */
@Service
@Transactional //(isolation = Isolation.REPEATABLE_READ)
public class CategoryServiceImpl extends BaseServiceImpl<Category>  implements CategoryService {

    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    @Override
    protected BaseDao<Category> getBaseDao() {
        return categoryDao;
    }

    @Override
    public boolean delete(Long id) {
        Category category = categoryDao.findOne(id);
        if (productDao.findByCategory(category).size() == 0){
            categoryDao.delete(category);
            return true;
        }
        return false;
    }
}
