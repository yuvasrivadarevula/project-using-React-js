package com.login.loginForm.service;

import com.login.loginForm.entity.User;
import com.login.loginForm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepo userRepo;

    public User findUserByID(int id){
        return userRepo.findById(id).orElse(null);
    }
}
