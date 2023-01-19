package com.example.testdrivenproject.service;

import com.example.testdrivenproject.entity.AppUser;
import com.example.testdrivenproject.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser findUserByUsername(String username) {
        return userRepo.findUserByUsername(username).orElseThrow();
    }

    @Transactional
    public boolean login(String username, String password) throws Exception {
        return true;
    }
}
