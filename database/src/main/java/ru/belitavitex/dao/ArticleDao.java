package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.*;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class ArticleDao extends BaseDao<Article> {

    public ArticleDao(){
        super(Article.class);
    }
}
