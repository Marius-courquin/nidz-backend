package com.nidz.home;

import com.nidz.home.dto.HomeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/homes")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public HomeDTO createHome(@RequestBody HomeDTO homeDTO) {
        Home home = convertToEntity(homeDTO);
        Home homeCreated = homeService.createHome(home);
        return convertToDTO(homeCreated);
    }

    @GetMapping("/{id}")
    public HomeDTO getHomeById(@PathVariable("id") UUID id) {
        Home home = homeService.getHomeById(id);
        return convertToDTO(home);
    }

    @PutMapping("/{id}")
    public HomeDTO updateHome(@PathVariable("id") UUID id, @RequestBody HomeDTO homeDTO) {
        Home home = convertToEntity(homeDTO);
        Home homeUpdated = homeService.updateHome(id, home);
        return convertToDTO(homeUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteHome(@PathVariable("id") UUID id) {
        homeService.deleteHome(id);
    }

    private HomeDTO convertToDTO(Home home) {
        return modelMapper.map(home, HomeDTO.class);
    }

    private Home convertToEntity(HomeDTO homeDTO) {
        return modelMapper.map(homeDTO, Home.class);
    }
}
