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
@ToString(exclude = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

//    public Person(String firstName, String lastName, String email, String password,
//                  Address address, String phone, Groups groups) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.phone = phone;
//        this.groups = groups;
//    }

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
    @OneToOne(cascade = CascadeType.ALL) //, fetch = FetchType.LAZY)
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

    @ManyToMany(mappedBy = "persons")
    @Getter
    @Setter
    private Set<Review> reviews = new HashSet<>();

    @Transient
    public String fullName() {
        return firstName + " " + lastName;
    }
}
