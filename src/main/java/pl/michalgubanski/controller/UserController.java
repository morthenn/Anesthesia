package pl.michalgubanski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by U6041021 on 07/11/2016.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String signup() {
        return "/security/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSuccess() {
        return "redirect:/";
    }
}
