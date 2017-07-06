package ru.belitavitex.entity;

import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dzianis on 08.06.2017.
 */
public class PromotionTest extends BaseTest<Promotion> {

    @Override
    protected Class<Promotion> getEntityClass() {
        return Promotion.class;
    }

    @Override
    protected Promotion getModel() {
        return createPromotion();
    }

    private Promotion createPromotion() {
        Promotion promotion = new Promotion();
        promotion.setName("New Year");
        promotion.setDateStart(LocalDate.of(2011, 12, 20));
        promotion.setDateEnd(LocalDate.of(2012, 01, 03));
        promotion.setDiscount(99);
        promotion.setProducts(new HashSet<>());
        return promotion;
    }

    @Test
    public void testGetPromotion() {
        Promotion promotion = createPromotion();
        assertNotNull(promotion.getName());
        assertNotNull(promotion.getDateStart());
        assertNotNull(promotion.getDateEnd());
        assertNotNull(promotion.getDiscount());
        assertNotNull(promotion.getProducts());
    }
}
