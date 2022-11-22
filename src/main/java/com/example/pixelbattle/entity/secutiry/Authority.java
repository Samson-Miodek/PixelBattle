package com.example.pixelbattle.entity.secutiry;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_MANAGER,
    ACCESS_TEST1,
    ACCESS_TEST2;

    @Override
    public String getAuthority() {
        return name();
    }
}
