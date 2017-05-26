package ru.belitavitex.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Dzianis on 28.03.2017.
 */
@Entity
@Table(name = "CustomerOrders")
@ToString
@NoArgsConstructor
public class CustomerOrder extends BaseEntity {
    @Getter
    @Setter
    private Person person;

    @Getter
    @Setter
    private Map<Product, Integer> orderItem;

    @Getter
    @Setter
    private LocalDate dateCreated;

    @Getter
    @Setter
    private LocalDate dateClosing;

    @Getter
    @Setter
    private OrderStatus orderStatus;

    public CustomerOrder(long id, Person person, Map<Product, Integer> orderItem,
                         LocalDate dateCreated, LocalDate dateClosing, OrderStatus orderStatus) {
        super(id);
        this.person = person;
        this.orderItem = orderItem;
        this.dateCreated = dateCreated;
        this.dateClosing = dateClosing;
        this.orderStatus = orderStatus;
    }
}

