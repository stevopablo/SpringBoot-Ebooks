package com.bookCulture.ebooks.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "mysecretekey";
    private final long EXPIRANTION_TIME = 864000000;
    public String generateToken(String email){
        return JWT.create()
                .withSubject(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String extractEmail(String token) {
        return decodeToken(token).getSubject();
    }

    public boolean validateToken(String token, String email) {
        return email.equals(extractEmail(token)) && !isTokenExpired(token);
    }

    private DecodedJWT decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }

    private boolean isTokenExpired(String token) {
        return decodeToken(token).getExpiresAt().before(new Date());
    }
}

