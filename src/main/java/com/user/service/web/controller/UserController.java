package com.user.service.web.controller;

import com.user.service.model.User;
import com.user.service.service.UserService;
import com.user.service.web.dto.UserDto;
import com.user.service.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        User user = UserMapper.toEntity(dto);
        service.save(user);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> getAll(Pageable pageable) {
        Page<UserDto> users = service.getAll(pageable).map(UserMapper::toDto);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        return service.getById(id)
                .map(UserMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable int id, @RequestBody UserDto dto) {
        User user = UserMapper.toEntity(dto);
        return service.getById(id)
                .map(u -> service.update(id, user))
                .map(UserMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    service.save(UserMapper.toEntity(dto));
                    return new ResponseEntity<>(dto, HttpStatus.CREATED);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id) {
        return service.getById(id)
                .map(u -> {
                    service.removeById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}