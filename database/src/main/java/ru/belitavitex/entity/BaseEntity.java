package ru.belitavitex.entity;
import lombok.*;
import javax.persistence.*;

/**
 * Created by Dzianis on 22.05.2017.
 */
@Entity
@Table(name = "id")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
}
