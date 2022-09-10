package com.learn.userauthentication.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWtAuthTokenFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String header = request.getHeader("Authorization");

            try {
                String token = header.split(" ")[1];
                Claims claims = Jwts.parser()
                        .setSigningKey("priyanshu-singh")
                        .parseClaimsJws(token)
                        .getBody();
                System.out.println(claims.getSubject() + "--" + claims.getIssuedAt());
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                response.sendRedirect("/unauthorized");
            }
        }

    @GetMapping("/unauthorized")
    public String invalidToken(){
        return "Access deniend";
    }
}

