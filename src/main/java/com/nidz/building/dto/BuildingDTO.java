package com.nidz.building.dto;


import com.nidz.address.dto.AddressDTO;
import com.nidz.auditing.dto.AuditingDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BuildingDTO extends AuditingDTO {
    private UUID id;
    private AddressDTO address;
    private UUID residence;
    private int number_of_floors;
    private boolean has_elevator;
}
