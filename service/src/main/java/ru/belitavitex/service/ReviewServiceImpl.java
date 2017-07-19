package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.ArticleDao;
import ru.belitavitex.dao.ReviewDao;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.*;
import ru.belitavitex.service.common.BaseServiceImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Service
@Transactional
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService{
    private final ReviewDao reviewDao;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    protected BaseDao<Review> getBaseDao() {
        return reviewDao;
    }


    public void saveFull(Review review) {
        if (review.getPerson() == null){
            Person person = new Person();
            User user = (User) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            person.setId(user.getId());
            review.setPerson(person);
        }
        review.setDateCreated(LocalDate.now());
        reviewDao.save(review);
    }

    @Override
    public void delete(Long id) {
        Review review = reviewDao.findOne(id);
        reviewDao.delete(review);
    }

    @Override
    public void publish(Long id) {
        Review review = reviewDao.findOne(id);
        review.setModeration(true);
        reviewDao.save(review);
    }

    public Set<Review> findAll(Boolean moderation){
        if (moderation){
            return reviewDao.findAll().stream()
                    .filter(Review::isModeration)
                    .collect(Collectors.toCollection(HashSet::new));
        }
        return reviewDao.findAll().stream()
                .filter(r -> !r.isModeration())
                .collect(Collectors.toCollection(HashSet::new));
    }
}
