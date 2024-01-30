package Audintel.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")

public class LoginControllerBKP {
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000/login")
    public String login(){
        System.out.println("in ######################login");
        return "hello";
    }
}
