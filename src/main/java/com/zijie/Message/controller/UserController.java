package com.zijie.Message.controller;

import com.zijie.Message.exception.MessageServiceException;
import com.zijie.Message.request.LoginUserRequest;
import com.zijie.Message.request.RegisterUserRequest;
import com.zijie.Message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserRequest registerUserRequest) throws MessageServiceException {
        this.userService.register(registerUserRequest);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginUserRequest loginUserRequest) throws MessageServiceException {
        this.userService.login(loginUserRequest);
    }
}
