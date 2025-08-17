package com.example.japanese.service;

import com.example.japanese.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class UserService {
    // Dùng username làm key, không cần Long id
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public boolean register(String username, String password, String email) {
        if (username == null || username.isBlank() || users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, email)); // dùng constructor username, password, email
        return true;
    }

    public User authenticate(String username, String password) {
        User u = users.get(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
}
