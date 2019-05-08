package com.user.service.service;

import com.user.service.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Page<User> getAll(Pageable pageable);

    User update(int id, User user);

    Optional<User> getById(int id);

    void removeById(int id);

    Optional<User> findByEmail(String email);
}
