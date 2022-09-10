package com.learn.userauthentication.config;

import com.learn.userauthentication.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator {
    @Override
    public Map<String, String> generatToken(User user) {


        String secretKey = "priyanshu-singh";
        String jwtToken="";

        jwtToken=Jwts.builder().signWith(SignatureAlgorithm.HS256,secretKey)
                .setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .compact();

        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","user authentication successful");
        return map;

    }
}
