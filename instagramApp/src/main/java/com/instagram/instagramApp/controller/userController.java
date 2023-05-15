package com.instagram.instagramApp.controller;

import com.instagram.instagramApp.dto.SignInInput;
import com.instagram.instagramApp.dto.SignInOutput;
import com.instagram.instagramApp.dto.SignUpInput;
import com.instagram.instagramApp.dto.SignUpOutput;
import com.instagram.instagramApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instagram")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);

    }

    //sign in
    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

}
