package ru.belitavitex.dao;

import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.common.BaseDaoImpl;
import ru.belitavitex.entity.OrderItem;
import ru.belitavitex.entity.Product;
import ru.belitavitex.entity.Review;

import java.util.List;

/**
 * Created by Dzianis on 10.07.2017.
 */
@Repository
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao{

    public List<Product> getBestSellers() {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("select p from OrderItem o " +
                        "join o.product p group by p order by o.quantity", Product.class)
                .setMaxResults(4)
                .getResultList();
    }
}
