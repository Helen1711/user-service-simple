package com.user.service.web.controller;

import com.user.service.model.User;
import com.user.service.service.UserSearchService;
import com.user.service.web.dto.UserDto;
import com.user.service.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserSearchController {
    private final UserSearchService service;

    @GetMapping("/search")
    public ResponseEntity<UserDto> getByEmail(@RequestParam String email) {
        Optional<User> user = service.findByEmail(email);
        return user.map(UserMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
