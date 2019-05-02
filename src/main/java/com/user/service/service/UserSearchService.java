package com.user.service.service;

import com.user.service.model.User;

import java.util.Optional;

public interface UserSearchService {
    Optional<User> findByEmail(String email);
}
