package ru.belitavitex.service;

import ru.belitavitex.entity.Article;
import ru.belitavitex.service.common.BaseService;

/**
 * Created by Dzianis on 24.06.2017.
 */

public interface ArticleService extends BaseService<Article>{
    void delete(Long id);
}