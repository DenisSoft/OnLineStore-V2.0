package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 28.03.2017.
 */
@Entity
@Table(name = "products")
@ToString(exclude = {"category", "reviews", "promotions"})
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntityWithName{

    @Getter
    @Setter
    @Column(name = "image")
    private String image;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "price")
    private Double price;

    @Getter
    @Setter
    @Column(name = "residue")
    private int residue;

    @OneToMany(mappedBy = "product")
    @Setter
    @Getter
    private Set<Review> reviews = new HashSet<>();

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    @Getter
    @Setter
    private Set<Promotion> promotions = new HashSet<>();
}
