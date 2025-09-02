package com.byte_trio.transaction_service.feign;

import com.byte_trio.transaction_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("AUTHENTICATION-SERVICE")
public interface AuthenticationFeignController {

    @GetMapping("/get-user")
    ResponseEntity<User> getUser(@RequestParam String username);
}
