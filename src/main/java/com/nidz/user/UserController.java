package com.nidz.user;

import com.nidz.user.dto.UserDTO;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User userCreated = userService.createUser(user);
        return convertToDTO(userCreated);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") UUID id) {
        User user = userService.getUserById(id);
        return convertToDTO(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable("id") UUID id, @RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User userUpdated = userService.updateUser(id, user);
        return convertToDTO(userUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }

    private UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}
