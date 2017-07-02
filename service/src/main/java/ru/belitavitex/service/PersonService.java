package ru.belitavitex.service;

import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Person;
import ru.belitavitex.service.common.BaseService;

import java.util.List;

/**
 * Created by Dzianis on 23.06.2017.
 */
public interface PersonService extends BaseService<Person> {
    List<Person> getPage(int maxResults, int firstResult);
    Long getCount();
    Person findByEmail(String email);
}
