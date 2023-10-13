package com.nidz.building;

import com.nidz.building.dto.BuildingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/buildings")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {
        Building building = convertToEntity(buildingDTO);
        Building buildingCreated = buildingService.createBuilding(building);
        return convertToDTO(buildingCreated);
    }

    @GetMapping("/{id}")
    public BuildingDTO getBuildingById(@PathVariable("id") UUID id) {
        Building building = buildingService.getBuildingById(id);
        return convertToDTO(building);
    }

    @PutMapping("/{id}")
    public BuildingDTO updateBuilding(@PathVariable("id") UUID id, @RequestBody BuildingDTO buildingDTO) {
        Building building = buildingService.updateBuilding(id, convertToEntity(buildingDTO));
        return convertToDTO(building);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable("id") UUID id) {
        buildingService.deleteBuilding(id);
    }

    private BuildingDTO convertToDTO(Building building) {
        return modelMapper.map(building, BuildingDTO.class);
    }

    private Building convertToEntity(BuildingDTO buildingDTO) {
        return modelMapper.map(buildingDTO, Building.class);
    }
}
