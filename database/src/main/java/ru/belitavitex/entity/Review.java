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
@ToString(exclude = {"person", "product", "article" })
@NoArgsConstructor
public class Review extends BaseEntity{

    @Setter
    @Getter
    @Column(name = "moderation")
    private boolean moderation;

    @Setter
    @Getter
    @Column(name = "comment")
    private String comment;

    @Getter
    @Setter
    @Column(name = "date_created_review")
    private LocalDate dateCreated;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @Setter
    @Getter
    @JoinColumn(name = "product_id")
    private Product product;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
