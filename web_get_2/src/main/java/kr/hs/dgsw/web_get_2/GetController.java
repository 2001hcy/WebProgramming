package kr.hs.dgsw.web_get_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
    @GetMapping("/greeting")
    public String greeting(String to){
        return "Hello "+to;
    }
}
