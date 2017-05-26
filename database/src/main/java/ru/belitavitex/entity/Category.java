package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Created by Dzianis on 07.04.2017.
 */
@Entity
@Table(name = "Categories")
@ToString
@NoArgsConstructor
public class Category extends BaseEntity {

    @Getter
    @Setter
    private String categoryName;

    public Category(long id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }
}
