package com.SpringBootExample.demo.service;

import com.SpringBootExample.demo.dto.UserDTO;
import com.SpringBootExample.demo.model.User;
import com.SpringBootExample.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO addUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public String deleteuser(int id) {
        // 1. Check if the user exists in the database using the ID
        if (userRepo.existsById(id)) {

            // 2. Delete the user directly by their ID
            userRepo.deleteById(id);

            return "User deleted successfully";
        } else {
            // 3. Return a meaningful message if the ID doesn't exist
            return "User not found with ID: " + id;
        }
    }

}
