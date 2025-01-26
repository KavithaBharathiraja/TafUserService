package com.example.TafUserService.Controller;

import com.example.TafUserService.Models.User;
import com.example.TafUserService.Service.Interfaces.TafuserserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")  // Base URL for this controller
public class TafUserController {

    @Autowired
    private TafuserserviceService tafuserserviceService;

    // Endpoint to register a new user
    @PostMapping()
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = tafuserserviceService.RegisterUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Endpoint to get all users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = tafuserserviceService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Endpoint to get a user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = tafuserserviceService.getUser(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // User not found
        }
    }

    // Endpoint to update a user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = tafuserserviceService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
