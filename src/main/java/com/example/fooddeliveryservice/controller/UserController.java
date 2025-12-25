package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.UserRequestDTO;
import com.example.fooddeliveryservice.dto.UserResponseDTO;
import com.example.fooddeliveryservice.entity.User;
import com.example.fooddeliveryservice.mapper.UserMapper;
import com.example.fooddeliveryservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        return ResponseEntity.ok(userMapper.toResponseDto(userService.register(user)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}