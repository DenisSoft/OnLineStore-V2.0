package ru.belitavitex.dao;

import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Promotion;

/**
 * Created by Dzianis on 12.06.2017.
 */
public class PromotionDao extends BaseDao<Promotion> {

    public PromotionDao(){
        super(Promotion.class);
    }
}
