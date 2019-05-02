package com.user.service.service.impl;

import com.user.service.model.User;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSearchServiceImpl implements UserSearchService {
    private final UserRepository repository;

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
