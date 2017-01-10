package pl.michalgubanski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "security/login")
    public String signup() {
        return "/security/login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginSuccess() {
//        return "redirect:/";
//    }
}
