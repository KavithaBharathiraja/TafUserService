package com.example.TafUserService.Models;

import java.time.LocalDateTime;
//import jakarta.persistence.*;

import lombok.Data;@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}