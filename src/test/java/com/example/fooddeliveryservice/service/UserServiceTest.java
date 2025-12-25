package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.User;
import com.example.fooddeliveryservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void registerUserTest() {
        User user = new User();
        user.setEmail("test@mail.com");
        user.setPassword("12345");

        // Сенің сервисіңде метод аты: register
        when(passwordEncoder.encode("12345")).thenReturn("encoded_12345");
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);

        User registered = userService.register(user);

        assertNotNull(registered);
        assertEquals("encoded_12345", registered.getPassword());
        verify(passwordEncoder).encode("12345");
        verify(userRepository).save(user);
    }

    @Test
    void getAllUsersTest() {
        User user = new User();
        user.setEmail("admin@food.kz");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> result = userService.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("admin@food.kz", result.get(0).getEmail());
    }
}