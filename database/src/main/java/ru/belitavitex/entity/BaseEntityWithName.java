package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Dzianis on 07.06.2017.
 */
@MappedSuperclass
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntityWithName extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
