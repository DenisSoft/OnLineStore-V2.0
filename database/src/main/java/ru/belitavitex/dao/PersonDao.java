package ru.belitavitex.dao;

import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Person;

import java.util.List;

/**
 * Created by Dzianis on 22.06.2017.
 */
public interface PersonDao extends BaseDao<Person> {
    List<Person> getPage(int maxResults, int firstResult);
    Long getCount();
    Person findByEmail(String email);
}
