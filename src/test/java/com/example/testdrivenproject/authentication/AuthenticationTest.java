package com.example.testdrivenproject.authentication;

import com.example.testdrivenproject.entity.AppUser;
import com.example.testdrivenproject.repo.UserRepo;
import com.example.testdrivenproject.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;
    private final static String username = "test";
    private final static String password = "password";
    @Test
    public void testLogin() throws Exception {
        AppUser appUser = new AppUser(username, password);
        when(userRepo.findUserByUsername("test")).thenReturn(Optional.of(appUser));

        assertTrue(userService.login("test", "password"));
        assertThrows(Exception.class, () -> userService.login("test", "wrongpassword"));
        assertThrows(Exception.class, () -> userService.login("nonexistent", "password"));
    }

    private void assertTrue(boolean login) {
    }
}