package com.byte_trio.api_gateway.feign;

import com.byte_trio.api_gateway.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthenticationFeignController {

    @GetMapping("/get-user")
    ResponseEntity<User> getUser(@RequestParam String username)
}
