package ru.belitavitex.dao;

import ru.belitavitex.dao.common.BaseDao;
import ru.belitavitex.entity.Article;
import ru.belitavitex.entity.OrderItem;
import ru.belitavitex.entity.Product;

import java.util.List;

/**
 * Created by Dzianis on 10.07.2017.
 */
public interface OrderItemDao extends BaseDao<OrderItem> {

    List<Product> getBestSellers();
}
