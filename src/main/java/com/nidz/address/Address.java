package com.nidz.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "num")
    private int num;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "post_code")
    private int postCode;
    @Column(name = "country")
    private String country;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;

}
