package com.example.potcontroll.controller;

import com.example.potcontroll.user.User;
import com.example.potcontroll.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * UserController is a REST controller that handles user-related operations.
 *
 * Alle Docs generiert mit GitHub Copilot
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * Registers a new user.
     *
     * @param user The user to be registered.
     * @return A ResponseEntity with the username if successful, or an error message if not.
     */
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        logger.info("Registering user: {}", user.getUsername());
        List<User> allreadyRegisteredUsers = userService.getAll();
        for(User registeredUser : allreadyRegisteredUsers) {
            if(registeredUser.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        logger.info("User registered: {}", user.getUsername());
        return new ResponseEntity<>(user.getUsername(), org.springframework.http.HttpStatus.OK);
    }

    /**
     * Logs in a user.
     *
     * @param user The user to be logged in.
     * @return A ResponseEntity with the username if successful, or an error message if not.
     */
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        logger.info("Logging in user: {}", user.getUsername());
        List<User> allreadyRegisteredUsers = userService.getAll();
        for(User registeredUser : allreadyRegisteredUsers) {
            if(registeredUser.getUsername().equals(user.getUsername())) {
                if(passwordEncoder.matches(user.getPassword(), registeredUser.getPassword())){
                    logger.info("User logged in: {}", user.getUsername());
                    return new ResponseEntity<>(user.getUsername(), org.springframework.http.HttpStatus.OK);
                }
            }
        }
        logger.info("User not found for login: {}", user.getUsername());
        return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }

    /**
     * Deletes a user.
     *
     * @param username The username of the user to be deleted.
     * @return A ResponseEntity with the username if successful, or an error message if not.
     */
    @CrossOrigin
    @DeleteMapping("/user/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        logger.info("Deleting user: {}", username);
        List<User> allreadyRegisteredUsers = userService.getAll();
        for(User registeredUser : allreadyRegisteredUsers) {
            if(registeredUser.getUsername().equals(username)) {
                userService.delete(registeredUser.getId());
                logger.info("User deleted: {}", username);
                return new ResponseEntity<>(username, org.springframework.http.HttpStatus.OK);
            }
        }
        logger.info("User not found for delete: {}", username);
        return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
