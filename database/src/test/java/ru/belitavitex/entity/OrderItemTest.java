package ru.belitavitex.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
        return createOrderItem();
    }

    private OrderItem createOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setCustomerOrder(new CustomerOrder());
        orderItem.setProduct(new Product());
        orderItem.setQuantity(5);
        return orderItem;
    }

    @Test
    public void testGetOrderItem() {
        OrderItem orderItem = createOrderItem();
        assertNotNull(orderItem.getCustomerOrder());
        assertNotNull(orderItem.getProduct());
        assertNotNull(orderItem.getQuantity());
    }
}