package com.training.Security;


import com.training.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;


@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

// public String generateAccessToken(User user) {
//        return Jwts.builder()
//                .subject(user.getId()
//                        .toString()) .claim("email", user.getEmail())
//                .claim("roles", user.getRoles().toString())`
// }


}
