package com.example.hd0403.Service;

import com.example.hd0403.Domain.User;

public interface UserService {
    User register(User user);
    boolean login(String id,String password);
}
