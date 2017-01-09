package pl.michalgubanski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by U6041021 on 07/11/2016.
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public String signup() {
        return "/security/login";
    }
}
