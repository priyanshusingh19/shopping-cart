package com.example.apiGateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey("priyanshu-singh").parseClaimsJws(token).getBody();
    }
}

