package ru.belitavitex.entity;

import java.time.LocalDate;

/**
 * Created by Dzianis on 08.06.2017.
 */
public class PromotionTest extends BaseTest<Promotion>{

    @Override
    protected Class<Promotion> getEntityClass() {
        return Promotion.class;
    }

    @Override
    protected Promotion getModel() {
        Promotion promotion = new Promotion();
        promotion.setName("New Year");
        promotion.setDateStart(LocalDate.of(2011,12,20));
        promotion.setDateEnd(LocalDate.of(2012,01,03));
        promotion.setDiscount(99);
        return new Promotion();
    }
}
