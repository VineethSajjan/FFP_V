package Audintel.controller;

import Audintel.dao.Member;
import Audintel.service.LoginService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {

    @Autowired
    private LoginService loginService;

        @CrossOrigin(origins = "http://localhost:3000/")
        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody Member member) {
            Gson gson = new Gson();
            if (loginService.isValidLogin(member)) {
                Member loggedInMember = loginService.getMemberByEmail(member.getEmail());

                return ResponseEntity.ok(gson.toJson(loggedInMember));
            } else {
                return ResponseEntity.badRequest().body(gson.toJson("Incorrect Email and Password not match"));
            }
        }
    }
