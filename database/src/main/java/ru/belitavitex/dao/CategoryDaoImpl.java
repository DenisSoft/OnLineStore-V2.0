package ru.belitavitex.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.Category;

import java.util.Locale;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
}
