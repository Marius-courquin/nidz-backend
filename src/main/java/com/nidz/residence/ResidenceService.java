package com.nidz.residence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ResidenceService")
public class ResidenceService {
    @Autowired
    private ResidenceRepository residenceRepository;

    public Residence createResidence(Residence residence) {
        return residenceRepository.save(residence);
    }

    public Residence getResidenceById(UUID id) {
        return residenceRepository.findById(id).orElse(null);
    }

    public Residence updateResidence(UUID id, Residence residence) {
        return residenceRepository.findById(id).map(residenceFound -> {
            residenceFound.setName(residence.getName());
            residenceFound.setDescription(residence.getDescription());
            residenceFound.setSyndicate(residence.getSyndicate());
            return residenceRepository.save(residenceFound);
        }).orElse(residenceRepository.save(residence));
    }

    public void deleteResidence(UUID id) {
        residenceRepository.deleteById(id);
    }
}
