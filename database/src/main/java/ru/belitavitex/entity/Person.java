package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Dzianis on 30.05.2017.
 */
@Entity
@Table(name = "persons")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addresses_id")
    private Address address;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "groups")
    private Groups groups;

    @Transient
    public String fullName() {
        return firstName + " " + lastName;
    }
}
