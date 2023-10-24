package com.nidz.residence;

import com.nidz.residence.dto.ResidenceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/residences")
public class ResidenceController {
    @Autowired
    private ResidenceService residenceService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public ResidenceDTO createResidence(@RequestBody ResidenceDTO residenceDTO) {
        Residence residence = convertToEntity(residenceDTO);
        Residence residenceCreated = residenceService.createResidence(residence);
        return convertToDTO(residenceCreated);
    }

    @GetMapping("/{id}")
    public ResidenceDTO getResidenceById(@PathVariable("id") UUID id) {
        Residence residence = residenceService.getResidenceById(id);
        System.out.println(residence);
        return convertToDTO(residence);
    }

    @PutMapping("/{id}")
    public ResidenceDTO updateResidence(@PathVariable("id") UUID id, @RequestBody ResidenceDTO residenceDTO) {
        Residence residence = residenceService.updateResidence(id, convertToEntity(residenceDTO));
        return convertToDTO(residence);
    }

    @DeleteMapping("/{id}")
    public void deleteResidence(@PathVariable("id") UUID id) {
        residenceService.deleteResidence(id);
    }

    private ResidenceDTO convertToDTO(Residence residence) {
        return modelMapper.map(residence, ResidenceDTO.class);
    }

    private Residence convertToEntity(ResidenceDTO residenceDTO) {
        return modelMapper.map(residenceDTO, Residence.class);
    }
}
