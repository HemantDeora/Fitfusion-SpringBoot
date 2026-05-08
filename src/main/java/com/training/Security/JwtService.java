package com.training.Security;


import com.training.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "ACCESS")
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 15)
                ) // 15 min
                .signWith(getSigningKey())
                .compact();
    }

    // Refresh Token
    public String generateRefreshToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "REFRESH")
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7)
                ) // 7 days
                .signWith(getSigningKey())
                .compact();
    }
    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

//    public Long getUserIdFromToken(String token) {
//        Claims claims = Jwts.parser()
//                .verifyWith(getSecretKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//        return Long.valueOf(claims.getSubject());
//    }



}
