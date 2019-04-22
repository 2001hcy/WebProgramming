package kr.hs.dgsw.blog.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping
    public String list(){
        return "Hello";
    }
}
