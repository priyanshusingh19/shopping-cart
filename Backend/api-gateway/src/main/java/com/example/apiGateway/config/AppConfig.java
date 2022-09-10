package com.example.apiGateway.config;
import com.example.apiGateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    AuthenticationFilter filter;
    @Autowired
    public AppConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                .path("/user/**")
                        .filters(f->f.filter(filter))
                        .uri("http://localhost:8080/"))
                .route(p->p
                        .path("/products/**")
                        .filters(f->f.filter(filter))
                        .uri("http://localhost:8081/"))
                .build();
    }

}
