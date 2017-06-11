package ru.belitavitex.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 01.06.2017.
 */
@Entity
@Table(name = "reviews")
@ToString(exclude = {"persons", "products"})
@NoArgsConstructor
public class Review extends BaseEntity{

    @Setter
    @Getter
    @Column(name = "comment")
    private String comment;

    @Getter
    @Setter
    @Column(name = "date_created_review")
    private LocalDate dateCreated;

    @ManyToMany
    @JoinTable(name = "persons_reviews",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @Setter
    @Getter
    private Set<Person> persons = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "products_reviews",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @Setter
    @Getter
    private Set<Product> products = new HashSet<>();

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articles;
}
