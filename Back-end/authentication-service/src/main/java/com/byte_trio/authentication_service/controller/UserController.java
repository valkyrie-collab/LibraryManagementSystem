package com.byte_trio.authentication_service.controller;

import com.byte_trio.authentication_service.model.User;
import com.byte_trio.authentication_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;
    @Autowired
    private void setService(UserService service) {this.service = service;}

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        return service.signIn(user.setRole("ROLE_" + user.getRole().toUpperCase()));
    }

    @PostMapping("/log-in")
    public ResponseEntity<String> logIn(@RequestBody User user) {
        return service.logIn(user.setRole("ROLE_" + user.getRole().toUpperCase()));
    }

    @GetMapping("/get-user")
    public ResponseEntity<User> getUser(@RequestParam String username) {
        return service.getUser(username);
    }
}
