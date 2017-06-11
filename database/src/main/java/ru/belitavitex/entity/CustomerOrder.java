package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dzianis on 28.03.2017.
 */
@Entity
@Table(name = "customer_orders")
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerOrder extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "person_id")
    @Setter
    @Getter
    private Person person;

    @OneToMany(mappedBy = "customerOrder")
    @Setter
    @Getter
    private Set<OrderItem> orderItems = new HashSet<>();

    @Getter
    @Setter
    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Setter
    @Getter
    @Column(name = "date_closing")
    private LocalDate dateClosing;

    @Getter
    @Setter
    @Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}

