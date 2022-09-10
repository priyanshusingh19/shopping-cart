package com.learn.userauthentication.controller;



import com.learn.userauthentication.config.JWTTokenGenerator;

import com.learn.userauthentication.model.User;
import com.learn.userauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;



    @GetMapping("/onlyforVerified")
    public String verified()
    {
        return "This is only for verified users";
    }


    @PostMapping("/Registration")
    public User registration(@RequestBody User user) {
        return this.userService.addNewUser(user);
    }

        @PostMapping("/login")

    public ResponseEntity<Object> LoginUser(@RequestBody User user)
    {
        User verified = userService.getUserInfo(user.getUserName(),user.getPassword());


        if(verified!=null)
        {
            Map<String, String> token = jwtTokenGenerator.generatToken(verified);
            return new ResponseEntity<Object>(token, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<Object>("invalid info ", HttpStatus.CONFLICT);
        }
    }

}
