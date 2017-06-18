package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Promotion;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class PromotionDao extends BaseDao<Promotion> {

    public PromotionDao(){
        super(Promotion.class);
    }
}
