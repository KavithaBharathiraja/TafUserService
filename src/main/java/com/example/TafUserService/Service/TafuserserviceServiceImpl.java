package com.example.TafUserService.Service;

import com.example.TafUserService.Models.User;
import com.example.TafUserService.Service.Interfaces.TafuserserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TafuserserviceServiceImpl implements TafuserserviceService {

    @Autowired
    private RestTemplate restTemplate;  // Used for calling the external service

    private static final String BASE_URL = "http://localhost:8080/datastore/users";  // URL for Datastore service

    @Override
    public User RegisterUser(User user) {
        // Send a POST request to TafDatastoreService to create a new user
        ResponseEntity<User> response = restTemplate.postForEntity(BASE_URL, user, User.class);
        return response.getBody();  // Return the created user
    }

    @Override
    public List<User> getAllUsers() {
        // Send a GET request to TafDatastoreService to fetch all users
        ResponseEntity<List> response = restTemplate.exchange(BASE_URL, org.springframework.http.HttpMethod.GET, null, List.class);
        return response.getBody();  // Return the list of users
    }

    @Override
    public User getUser(Long userId) {
        // Send a GET request to TafDatastoreService to fetch a user by ID
        String url = BASE_URL + "/" + userId;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        return response.getBody();  // Return the user if found
    }

    @Override
    public User updateUser(Long userId, User user) {
        // Send a PUT request to TafDatastoreService to update the user by ID
        String url = BASE_URL + "/" + userId;
        restTemplate.put(url, user);  // No response expected, just update the user
        return user;  // Return the updated user (or handle as necessary)
    }
}
