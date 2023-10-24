package com.nidz.building;

import com.nidz.address.Address;
import com.nidz.auditing.Auditing;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "buildings")
public class Building extends Auditing {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;
    @Column(name = "residence")
    private UUID residence;
    @Column(name = "number_of_floors")
    private int numberOfFloors;
    @Column(name = "has_elevator")
    private boolean hasElevator;
}
