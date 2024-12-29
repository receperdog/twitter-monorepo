package com.rh.authservice.dto;

public record AuthenticationRequest(
        String username,
        String password
) {}