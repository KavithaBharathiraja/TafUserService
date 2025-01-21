package com.example.TafUserService.Service.Interfaces;



import com.example.TafUserService.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface TafuserserviceService {


    User RegisterUser(User user);
    List<User> getAllUsers();
    User getUser(Long userId);
    User updateUser(Long userId, User user);



}
