package com.byte_trio.api_gateway.config;

import com.byte_trio.api_gateway.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final User user;

    private CustomUserDetails(User user) {this.user = user;}

    public static CustomUserDetails initialize(User user) {return new CustomUserDetails(user);}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = user.getRole();

        if (role == null || role.isEmpty()) {return List.of();}

        String[] roles = role.split(",");

        return Arrays.stream(roles).map(String::trim)
                .filter(r -> !r.isEmpty())
                .map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
