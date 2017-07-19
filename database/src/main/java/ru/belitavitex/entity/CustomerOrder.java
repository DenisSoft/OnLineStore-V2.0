package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Dzianis on 28.03.2017.
 */
@Entity
@Table(name = "customer_orders")
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orderItems")
public class CustomerOrder extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "person_id")
    @Setter
    @Getter
    private Person person;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
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

    public int quantityInCart(){
        return orderItems.stream().mapToInt(o -> o.getQuantity()).sum();
    }

    public double shoppingCart(){
        return orderItems.stream().mapToDouble(o -> o.cost()).sum();
    }

    public void addToCart(OrderItem orderItem){
        Optional<OrderItem> matchingObjects= orderItems
                .stream()
                .filter(o -> o.getProduct().getId().equals(orderItem.getProduct().getId()))
                .findFirst();
        OrderItem available = matchingObjects.orElse(null);
        if (available != null){
            available.setQuantity(available.getQuantity()+orderItem.getQuantity());
        }else{
            orderItems.add(orderItem);
        }
    }

    public void removeToCart(Long id){
        Optional<OrderItem> matchingObjects= orderItems
                .stream()
                .filter(o -> o.getProduct().getId().equals(id))
                .findFirst();
        OrderItem available = matchingObjects.orElse(null);
        if (available != null){
            orderItems.remove(available);
        }
    }
}

