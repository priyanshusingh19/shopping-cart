package com.learn.userauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class UserAuthenticationApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}
}
