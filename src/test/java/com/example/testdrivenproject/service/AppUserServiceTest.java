package com.example.testdrivenproject.service;

import com.example.testdrivenproject.entity.AppUser;
import com.example.testdrivenproject.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

    @Mock
    UserRepo userRepo;
    private UserService userService;
    private final static String username = "nico";
    private final static String password = "nico!";
    @BeforeEach
    public void init(){
        userService = new UserService(userRepo);
    }
    @Test
    public void findUserByUsername_withCorrectUsername_shouldReturnUser() {
        // Given
        AppUser appUser = new AppUser(username, password);

        // When
        when(userRepo.findUserByUsername(username)).thenReturn(Optional.of(appUser));
        AppUser returnedAppUser = userService.findUserByUsername(username);

        // Assert
        assertEquals(appUser, returnedAppUser);
        verify(userRepo, times(1)).findUserByUsername(username);

    }
}
