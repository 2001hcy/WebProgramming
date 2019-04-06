package com.example.hd0403.Service;

import com.example.hd0403.Domain.User;
import com.example.hd0403.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean login(String id, String password) {
        return false;
    }
}
