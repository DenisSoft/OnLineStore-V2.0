package ru.belitavitex.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Dzianis on 01.06.2017.
 */

@Entity
@Table(name = "addresses")
@ToString(exclude = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity{

    public Address(String country, String city, String street, Integer house,
                   Integer building, Integer apartment, String zip) {
        this.country = country;
        this.street = street;
        this.house = house;
        this.building = building;
        this.apartment = apartment;
        this.city = city;
        this.zip = zip;
    }

    @Getter
    @Setter
    @Column(name = "country")
    private String country;

    @Getter
    @Setter
    @Column(name = "street")
    private String street;

    @Getter
    @Setter
    @Column(name = "house")
    private Integer house;

    @Getter
    @Setter
    @Column(name = "building")
    private Integer building;

    @Getter
    @Setter
    @Column(name = "apartment")
    private Integer apartment;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    @Getter
    @Setter
    @Column(name = "zip")
    private String zip;

    @OneToOne(mappedBy = "address")
    @Getter
    @Setter
    private Person person;
}
