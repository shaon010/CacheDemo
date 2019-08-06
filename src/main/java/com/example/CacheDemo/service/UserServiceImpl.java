package com.example.CacheDemo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserServie {

    @Cacheable(value = "user", key = "#id", cacheManager = "caffeineCacheManager")
    @Override
    public String getUsername(String id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
        }

        return "User -> " + id;
    }

    @Cacheable(value = "user")
    @Override
    public ArrayList<String> getUserList() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) { }

        ArrayList<String> userList = new ArrayList<>();
        userList.add("Tom");
        userList.add("jerry");
        return userList;
    }
}
