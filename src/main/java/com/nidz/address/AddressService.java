package com.nidz.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("AddressService")
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(UUID id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address updateAddress(UUID id, Address address) {
        return addressRepository.findById(id).map(addressFound -> {
            addressFound.setNum(address.getNum());
            addressFound.setStreet(address.getStreet());
            addressFound.setCity(address.getCity());
            addressFound.setPostCode(address.getPostCode());
            addressFound.setCountry(address.getCountry());
            addressFound.setLatitude(address.getLatitude());
            addressFound.setLongitude(address.getLongitude());
            return addressRepository.save(addressFound);
        }).orElse(addressRepository.save(address));
    }
}
