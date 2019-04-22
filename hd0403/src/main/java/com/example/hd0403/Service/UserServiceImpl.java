package com.example.hd0403.Service;

import com.example.hd0403.Domain.User;
import com.example.hd0403.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User login(String id, User user) {
        Optional<User> found = this.userRepository.findById(id);
        if (found.isPresent()) {
            User temp = found.get();
            if (temp.getPassword().equals(user.getPassword())) {
                return temp;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public User update(User user) {
        Optional<User> found = this.userRepository.findById(user.getId());
        if (found.isPresent()) {
            User u = found.get();
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setUsername((user.getUsername()));
            u.setPassword((user.getPassword()));
            return this.userRepository.save(u);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
