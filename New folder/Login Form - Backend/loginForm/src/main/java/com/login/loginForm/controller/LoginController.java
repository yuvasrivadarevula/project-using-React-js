package com.login.loginForm.controller;

import com.login.loginForm.entity.User;
import com.login.loginForm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public User validateUser(@RequestBody User user){

        System.out.println(user.toString());

        User u = loginService.findUserByID(Integer.parseInt(user.getID()));

        if(u!=null && u.getPassword().equals(user.getPassword())){
            System.out.println(u.toString());
            return u;
        }else{
            User u1 = new User("dummy","0","000");
            return u1;
        }
    }
}
