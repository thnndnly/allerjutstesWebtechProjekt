package com.example.potcontroll.controller;

import com.example.potcontroll.user.User;
import com.example.potcontroll.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        List<User> allreadyRegisteredUsers = userService.getAll();
        for(User registeredUser : allreadyRegisteredUsers) {
            if(registeredUser.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
            }
        }
        userService.save(user);
        return new ResponseEntity<>(user.getUsername(), org.springframework.http.HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        List<User> allreadyRegisteredUsers = userService.getAll();
        for(User registeredUser : allreadyRegisteredUsers) {
            if(registeredUser.getUsername().equals(user.getUsername())) {
                if(registeredUser.getPassword().equals(user.getPassword())) {
                    return new ResponseEntity<>(user.getUsername(), org.springframework.http.HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @DeleteMapping("/user/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        List<User> allreadyRegisteredUsers = userService.getAll();
        for(User registeredUser : allreadyRegisteredUsers) {
            if(registeredUser.getUsername().equals(username)) {
                userService.delete(registeredUser.getId());
                return new ResponseEntity<>(username, org.springframework.http.HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
