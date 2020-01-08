package com.example.CacheDemo.service;

import com.example.CacheDemo.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserServie {

    /**
     * Using caffeine as cache manager
     * @param id
     * @return
     */
    @Cacheable(value = "user", key = "#id", cacheManager = "caffeineCacheManager")
    @Override
    public String getUsername(String id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
        }

        return "User -> " + id;
    }

    /**
     * Using default cacheManager,
     * which is redis as configured in {@link CacheConfig}
     * @return
     */
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
