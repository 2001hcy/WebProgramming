package com.example.hd0403.Controller;


import com.example.hd0403.Domain.User;
import com.example.hd0403.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        return this.userService.register(user);
    }

    @PostMapping("/user/login/{id}")
    public User login(@PathVariable String id,@RequestBody User user){
        return this.userService.login(id,user);
    }

    @PostMapping("/user/update")
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean delete(@PathVariable String id){
        return this.userService.delete(id);
    }
}
