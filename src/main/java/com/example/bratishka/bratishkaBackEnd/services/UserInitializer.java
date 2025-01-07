package com.example.bratishka.bratishkaBackEnd.services;

import com.example.bratishka.bratishkaBackEnd.models.User;
import com.example.bratishka.bratishkaBackEnd.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInitializer {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initializeAdminUser() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("$2y$10$xLH/TSmZZwkhagV5j5WDn..v9N1dvVbuwLItiApQ/dZBPI1LqmG2S");
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);
            System.out.println("Admin user created");
        } else {
            System.out.println("Admin user already exists");
        }
    }
}