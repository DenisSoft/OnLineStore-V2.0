package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 08.06.2017.
 */
@Entity
@Table(name = "promotions")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Promotion extends BaseEntityWithName{

    @Getter
    @Setter
    @Column(name = "date_start")
    private LocalDate dateStart;

    @Setter
    @Getter
    @Column(name = "date_end")
    private LocalDate dateEnd;

    @ManyToMany
    @JoinTable(name = "products_promotions",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @Setter
    @Getter
    private Set<Product> products = new HashSet<>();

    @Setter
    @Getter
    @Column(name = "discount")
    private int discount;
}
