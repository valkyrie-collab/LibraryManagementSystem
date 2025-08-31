package com.byte_trio.authentication_service.service;

import com.byte_trio.authentication_service.Repository.UserRepository;
import com.byte_trio.authentication_service.config.TokenConfig;
import com.byte_trio.authentication_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(12);

    private UserRepository repo;
    @Autowired
    private void setRepo(UserRepository repo) {this.repo = repo;}

    private AuthenticationManager authenticationManager;
    @Autowired
    private void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private TokenConfig config;
    @Autowired
    private void setConfig(TokenConfig config) {this.config = config;}

    public ResponseEntity<String> signIn(User user) {
        boolean checkUser = repo.findById(user.getUsername()).orElse(null) != null;

        if (checkUser) {return ResponseEntity.status(HttpStatus.OK).body("The user is present log in ");}

        repo.save(user.setPassword(ENCODER.encode(user.getPassword())));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The user sign in successfully log in plz");
    }

    public ResponseEntity<String> logIn(User user) {
        String token = null;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            token = config.generateToken(user.getUsername(), authentication.getAuthorities());
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(token);
    }

    public ResponseEntity<User> getUser(String username) {
        User user = repo.findById(username).orElse(null);

        return user == null? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) :
                ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
