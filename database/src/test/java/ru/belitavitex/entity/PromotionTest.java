package ru.belitavitex.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.belitavitex.util.PersonTestDataImporter;
import ru.belitavitex.util.ProductTestDataImporter;

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
