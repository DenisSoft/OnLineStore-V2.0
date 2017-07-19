package ru.belitavitex.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Category;
import ru.belitavitex.service.common.BaseService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by Dzianis on 14.06.2017.
 */

public class CategoryServiceTest extends BaseServiceTest<Category>{

    @Autowired
    private BaseService<Category> service;

    @Autowired
    private CategoryService categoryService;

    @Override
    protected BaseService<Category> getService() {
        return service;
    }

    @Override
    protected Category getModel() {
        return new Category();
    }

    @Test
    public void testDelete() {
        Category category = new Category();
        categoryService.save(category);
        Long id = category.getId();
        assertNotNull(categoryService.findOne(id));
        categoryService.delete(id);
        assertNull(categoryService.findOne(id));
    }
}
