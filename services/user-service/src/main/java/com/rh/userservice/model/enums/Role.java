package com.rh.userservice.model.enums;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_USER(1L, "USER"),
    ROLE_ADMIN(2L, "ADMIN");

    @Id
    private Long id;
    private String roleName;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
