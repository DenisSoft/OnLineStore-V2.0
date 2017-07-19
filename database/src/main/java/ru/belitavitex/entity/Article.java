package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 08.06.2017.
 */
@Entity
@Table(name = "articles")
@ToString(exclude = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseEntityWithName {

    @Setter
    @Getter
    @Column(name = "text")
    private String text;

    @Getter
    @Setter
    @Column(name = "date_created")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "article")
    @Setter
    @Getter
    private Set<Review> reviews = new HashSet<>();

    @Getter
    @Setter
    @Column(name = "image")
    private String image;
}
