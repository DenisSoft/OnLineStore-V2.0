package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 30.05.2017.
 */
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "products")
public class Category extends BaseEntityWithName{

    public Category(String name) {
        super(name);
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    @Version
    @Getter
    @Setter
    @Column(name = "version")
    private long version;

}
