package ru.belitavitex.entity;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Dzianis on 28.03.2017.
 */
public class CustomerOrder extends BaseEntity {
    private Person person;
    private Map<Product, Integer> orderItem;
    private LocalDate dateCreated;
    private LocalDate dateClosing;
    private OrderStatus orderStatus;

    public CustomerOrder(long id, Person person, Map<Product, Integer> orderItem, LocalDate dateCreated, LocalDate dateClosing, OrderStatus orderStatus) {
        super(id);
        this.person = person;
        this.orderItem = orderItem;
        this.dateCreated = dateCreated;
        this.dateClosing = dateClosing;
        this.orderStatus = orderStatus;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Map<Product, Integer> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Map<Product, Integer> orderItem) {
        this.orderItem = orderItem;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateClosing() {
        return dateClosing;
    }

    public void setDateClosing(LocalDate dateClosing) {
        this.dateClosing = dateClosing;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "person=" + person +
                ", orderItem=" + orderItem +
                ", dateCreated=" + dateCreated +
                ", dateClosing=" + dateClosing +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

