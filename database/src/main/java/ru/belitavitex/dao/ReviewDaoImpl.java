package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Promotion;
import ru.belitavitex.entity.Review;

/**
 * Created by Dzianis on 12.06.2017.
 */
@Repository
public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao {

    @Override
    public void publish(Long id) {
        getSessionFactory()
                .getCurrentSession()
                .createQuery ("update Review set moderation = true where id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
