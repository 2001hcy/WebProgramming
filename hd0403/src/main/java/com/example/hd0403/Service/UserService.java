package com.example.hd0403.Service;

import com.example.hd0403.Domain.User;

public interface UserService {
    User register(User user);
    User login(String id,User user);
    User update(User user);
    boolean delete(String id);
}
