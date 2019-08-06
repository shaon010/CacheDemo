package com.example.CacheDemo.controller;

import com.example.CacheDemo.service.UserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class User {

    private UserServie userServie;

    @Autowired
    public User(UserServie userServie) {
        this.userServie = userServie;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable String id) {
        return userServie.getUsername(id);
    }

    @GetMapping("/user/")
    public ArrayList<String> getUserList() {
        return userServie.getUserList();
    }
}
