package ru.belitavitex.entity;

import java.util.HashSet;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class OrderItemTest extends BaseTest<OrderItem> {

    @Override
    protected Class<OrderItem> getEntityClass() {
        return OrderItem.class;
    }

    @Override
    protected OrderItem getModel() {
        OrderItem orderItem = new OrderItem();
        orderItem.setCustomerOrder(new CustomerOrder());
        orderItem.setProduct(new Product());
        orderItem.setQuantity(5);
        return orderItem;
    }
}