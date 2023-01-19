package com.example.testdrivenproject.repo;

import com.example.testdrivenproject.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findUserByUsername(String username);
}
