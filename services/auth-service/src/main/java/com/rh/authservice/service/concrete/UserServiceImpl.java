package com.rh.authservice.service.concrete;

import com.rh.authservice.dto.UserRegisterRequest;
import com.rh.authservice.model.User;
import com.rh.authservice.model.enums.Role;
import com.rh.authservice.repository.UserRepository;
import com.rh.authservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserRegisterRequest user) {

        User newUser = User.builder().username(user.username())
                .name(user.name())
                .email(user.email())
                .password(passwordEncoder.encode(user.password()))
                .authorities(Set.of(Role.ROLE_USER))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .isEnabled(true)
                .credentialsNonExpired(true)
                .build();
        userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}