package com.nidz.building;

import com.nidz.address.Address;
import com.nidz.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("BuildingService")
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private AddressService addressService;

    public Building createBuilding(Building building) {
        Address address = addressService.createAddress(building.getAddress());
        building.setAddress(address);
        return buildingRepository.save(building);
    }


    public Building getBuildingById(UUID id) {
        return buildingRepository.findById(id).orElse(null);
    }

    public Building updateBuilding(UUID id, Building building) {
        return buildingRepository.findById(id).map(buildingFound -> {
            Address updatedAddress = addressService.updateAddress(buildingFound.getAddress().getId(), building.getAddress());
            buildingFound.setAddress(updatedAddress);
            buildingFound.setResidence(building.getResidence());
            buildingFound.setNumberOfFloors(building.getNumberOfFloors());
            buildingFound.setHasElevator(building.isHasElevator());
            return buildingRepository.save(buildingFound);
        }).orElse(buildingRepository.save(building));
    }

    public void deleteBuilding(UUID id) {
        buildingRepository.deleteById(id);
    }
}
