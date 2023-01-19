package com.example.testdrivenproject.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AppUserServiceTest {

    @Mock
    UserRepo userRepo;

    private UserService userService;
    private final static String username = "nico";
    private final static String password = "nico!";
    private final static long id = 1;

    @Test
    public void findUserByUsername_withCorrectUsername_shouldReturnUser() {
        // Given
        AppUser appUser = new AppUser(id, username, password);

        // When
        when(userRepo.findUserByUsername(username)).thenReturn(Optional.of(appUser));
        AppUser returnedAppUser = userService.findUserByUsername(username);

        // Assert
        assertEquals(appUser, returnedAppUser);
        verify(userRepo, times(1)).findUserByUsername(username);

    }
}
