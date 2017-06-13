package ru.belitavitex.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category extends BaseEntityWithName{

    public Category(String name) {
        super(name);
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

}
