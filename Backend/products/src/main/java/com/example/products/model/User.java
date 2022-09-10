package com.example.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "users")
public class User {
    @Id
    private String userName;
    private List<CartItems> cart;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<CartItems> getCart() {
        return cart;
    }

    public void setCart(List<CartItems> cart) {
        this.cart = cart;
    }

    public User(String userName, List<CartItems> cart)   {
        this.userName = userName;
        this.cart = cart;
    }
}
