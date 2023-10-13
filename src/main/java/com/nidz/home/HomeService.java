package com.nidz.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("HomeService")
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public Home createHome(Home home) {
        return homeRepository.save(home);
    }

    public Home getHomeById(UUID id) {
        return homeRepository.findById(id).orElse(null);
    }

    public Home updateHome(UUID id, Home home) {
        return homeRepository.findById(id).map(homeFound -> {
            homeFound.setOwner(home.getOwner());
            homeFound.setFloor(home.getFloor());
            homeFound.setResident(home.getResident());
            homeFound.setNum(home.getNum());
            homeFound.setBuilding(home.getBuilding());
            return homeRepository.save(homeFound);
        }).orElse(homeRepository.save(home));
    }

    public void deleteHome(UUID id) {
        homeRepository.deleteById(id);
    }
}
