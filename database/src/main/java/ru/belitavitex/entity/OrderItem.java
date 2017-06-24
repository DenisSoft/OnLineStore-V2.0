package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Dzianis on 07.06.2017.
 */
@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem extends BaseEntity {

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    @Getter
    @Setter
    private CustomerOrder customerOrder;

    @OneToOne
    @JoinColumn(name="product_id")
    @Getter
    @Setter
    private Product product;

    @Column(name = "quantity", nullable = false)
    @Getter
    @Setter
    private int quantity;

}
