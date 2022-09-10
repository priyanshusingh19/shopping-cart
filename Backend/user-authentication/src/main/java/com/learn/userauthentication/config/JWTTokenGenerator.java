package com.learn.userauthentication.config;



import com.learn.userauthentication.model.User;

import java.util.Map;

public interface JWTTokenGenerator {

    public Map<String ,String> generatToken(User user);
}
