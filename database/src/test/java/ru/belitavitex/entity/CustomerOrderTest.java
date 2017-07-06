package ru.belitavitex.entity;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dzianis on 07.06.2017.
 */
public class CustomerOrderTest extends BaseTest<CustomerOrder> {

    @Override
    protected Class<CustomerOrder> getEntityClass() {
        return CustomerOrder.class;
    }

    @Override
    protected CustomerOrder getModel() {
        return createCustomerOrder();
    }

    private CustomerOrder createCustomerOrder() {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderStatus(OrderStatus.CLOSED);
        customerOrder.setDateClosing(LocalDate.of(2011, 03, 03));
        customerOrder.setDateCreated(LocalDate.of(2011, 03, 01));
        customerOrder.setPerson(new Person());
        return customerOrder;
    }

    @Test
    public void testGetCustomerOrder() {
        CustomerOrder customerOrder = createCustomerOrder();
        assertNotNull(customerOrder.getOrderStatus());
        assertNotNull(customerOrder.getDateClosing());
        assertNotNull(customerOrder.getDateCreated());
        assertNotNull(customerOrder.getPerson());
    }
}
