package com.byte_trio.api_gateway.config;

//import com.byte_trio.authentication_service.Repository.UserRepository;
import com.byte_trio.api_gateway.feign.AuthenticationFeignController;
import com.byte_trio.api_gateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class CustomUserDetailsService implements UserDetailsService {
//    private UserRepository repo;
//    @Autowired
//    private void setRepo(UserRepository repo) {this.repo = repo;}

    private AuthenticationFeignController feign;
    @Autowired
    private void setFeign(AuthenticationFeignController feign) {this.feign = feign;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = feign.getUser(Base64.getEncoder().encodeToString(username.getBytes())).getBody();//repo.findById(username).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("USER-404");
        }

        return CustomUserDetails.initialize(user);
    }
}
