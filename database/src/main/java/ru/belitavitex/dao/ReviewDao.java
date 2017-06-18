package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Review;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class ReviewDao extends BaseDao<Review> {

    public ReviewDao(){
        super(Review.class);
    }
}
