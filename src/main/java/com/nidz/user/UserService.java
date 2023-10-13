package com.nidz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(UUID id, User user) {
        User updatedUser = userRepository.findById(id).map(userFound -> {
            userFound.setLastName(user.getLastName());
            userFound.setFirstName(user.getFirstName());
            userFound.setBirthDate(user.getBirthDate());
            userFound.setCountry(user.getCountry());
            userFound.setGender(user.getGender());
            userFound.setAvatar(user.getAvatar());
            userFound.setEmail(user.getEmail());
            userFound.setPhone(user.getPhone());
            return userRepository.save(userFound);
        }).orElse(userRepository.save(user));
        return updatedUser;
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}
