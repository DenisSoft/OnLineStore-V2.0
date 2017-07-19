package ru.belitavitex.service;

import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Review;
import ru.belitavitex.service.common.BaseService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 24.06.2017.
 */
public interface ReviewService extends BaseService<Review> {

    Set<Review> findAll(Boolean moderation);
    void delete(Long id);
    void publish(Long id);
    void saveFull(Review review);
}
