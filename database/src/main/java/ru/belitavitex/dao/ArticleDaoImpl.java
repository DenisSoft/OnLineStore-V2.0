package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.Article;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {
}
