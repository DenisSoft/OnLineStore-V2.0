package ru.belitavitex.entity;
import lombok.*;
import javax.persistence.*;

/**
 * Created by Dzianis on 22.05.2017.
 */
@MappedSuperclass
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column (name = "id")
    private Long id;
}
