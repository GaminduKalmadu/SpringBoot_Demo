package com.SpringBootExample.demo.Controller;

import com.SpringBootExample.demo.dto.UserDTO;
import com.SpringBootExample.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserDTO> getusers(){
        return userService.getAllUsers();
    }

    @PostMapping("/adduser")
    public UserDTO adduser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping("/updateuser")
    public UserDTO updateuser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable int id) {
        return userService.deleteuser(id);
    }
}
