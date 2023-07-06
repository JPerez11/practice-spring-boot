package com.example.practice.configuration.jwt;

import com.example.practice.services.impl.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Date;

public class JwtProvider {

    public static final String TOKEN_HEADER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    public static final Long TOKEN_EXPIRED = 3_600_000L;

    private JwtProvider(){}

    public static String generateToken(UserDetails userDetails) {
        Date tokenExpired = new Date(System.currentTimeMillis() + TOKEN_EXPIRED);

        String email = userDetails.getUsername();
        String role = ((UserDetailsImpl) userDetails).getRoleName();

        Claims claims = Jwts.claims();
        claims.setSubject(email);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(Keys.hmacShaKeyFor(TOKEN_HEADER.getBytes()))
                .setExpiration(tokenExpired)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(TOKEN_HEADER.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        String email = claims.getSubject();
        String role = (String) claims.get("role");

        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        return new UsernamePasswordAuthenticationToken(
                email,
                null,
                Collections.singletonList(authority)
        );
    }

    public static boolean verifyToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(TOKEN_HEADER.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }
}
