package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.ArticleDao;
import ru.belitavitex.dao.PromotionDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Promotion;
import ru.belitavitex.service.common.BaseServiceImpl;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class PromotionServiceImpl extends BaseServiceImpl<Promotion> implements PromotionService {
    private final PromotionDao promotionDao;

    @Autowired
    public PromotionServiceImpl(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    @Override
    protected BaseDao<Promotion> getBaseDao() {
        return promotionDao;
    }
}
