package com.rh.authservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRegisterRequest(
        @NotNull
        String name,
        @NotNull
        String surname,
        @NotNull
        String username,
        @NotNull
        String password,
        @Email
        String email
) {
}