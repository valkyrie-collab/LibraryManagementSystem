package com.byte_trio.authentication_service.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Component
public class TokenConfig {
    private static final int Expiration = 1000 * 60 * 60 * 30;

    @Value("${jwts.security}")
    private String securityKey;

    private Key generateKey() {return Keys.hmacShaKeyFor(Decoders.BASE64.decode(securityKey));}

    private <I> I getClaims(String token, Function<Claims, I> claimsBearer) {
        return claimsBearer.apply(
                Jwts.parserBuilder().setSigningKey(generateKey()).build()
                        .parseClaimsJws(token).getBody()
        );
    }

    private boolean isExpired(String token) {
        return !getClaims(token, Claims::getExpiration).before(new Date());
    }

    public String generateToken(String username,
                                Collection<? extends GrantedAuthority> authorities) {
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority).toList();
        Map<String, Object> claims = new HashMap<>(); claims.put("roles", roles);

        return Jwts.builder().setClaims(claims).setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Expiration))
                .signWith(generateKey()).compact();
    }

    public String getUsername(String token) {return getClaims(token, Claims::getSubject);}

    public boolean isValid(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(getUsername(token)) && isExpired(token);
    }
}
