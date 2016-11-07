package pl.michalgubanski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by U6041021 on 07/11/2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
