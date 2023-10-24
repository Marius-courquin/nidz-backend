package com.nidz.address.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String id;
    private int num;
    private String street;
    private String city;
    private int post_code;
    private String country;
    private float latitude;
    private float longitude;
}
