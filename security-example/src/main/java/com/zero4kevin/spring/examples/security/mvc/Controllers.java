package com.zero4kevin.spring.examples.security.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kevin on 2/3/18.
 */
@Controller
public class Controllers {
    @RequestMapping("/")
    public String startPage(){
        return "home";
    }

    @RequestMapping("/member")
    public String memberPage(){
        return "members";
    }
}
