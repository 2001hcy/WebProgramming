package com.example.hd0403.Controller;


import com.example.hd0403.Domain.User;
import com.example.hd0403.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        return this.userService.register(user);
    }

    @PostMapping("/user/login")
    public boolean login(String id, String password){
        return this.userService.login(id,password);
    }
}
