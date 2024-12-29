package com.rh.authservice.service;


import com.rh.authservice.dto.UserRegisterRequest;
import com.rh.authservice.model.User;

import java.util.Optional;

public interface UserService {

    void saveUser(UserRegisterRequest user);
    Optional<User> findByUsername(String username);
}