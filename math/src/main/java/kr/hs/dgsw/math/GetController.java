package kr.hs.dgsw.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
    @GetMapping("/calculate")
    public String Calculate(
            @RequestParam(required = false, defaultValue = "0") String x,
            @RequestParam(required = false, defaultValue = "0") String y,
            @RequestParam(required = false, defaultValue = "plus") String sign
    ) {
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        int result = 0;
        switch (sign){
            case "plus":
                result = (X+Y);
                break;
            case "minus":
                result = (X-Y);
                break;
            case "multi":
                result = (X*Y);
                break;
            case "div":
                result = (X/Y);
        }
        return Integer.toString(result);
    }
}
