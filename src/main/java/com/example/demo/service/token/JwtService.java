package com.example.demo.service.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.dao.jpa.entity.UserEntity;

@Service
public class JwtService {

    private static final String SECRET_KEY = "estaEsUnaClaveMuySeguraQueDebeTenerAlMenos256Bits123!";

    public String generateToken(UserEntity user) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hora
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
