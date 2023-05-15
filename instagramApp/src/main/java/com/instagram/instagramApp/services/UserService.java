package com.instagram.instagramApp.services;

import com.instagram.instagramApp.Model.AuthenticationToken;
import com.instagram.instagramApp.Model.User;
import com.instagram.instagramApp.dto.SignInInput;
import com.instagram.instagramApp.dto.SignInOutput;
import com.instagram.instagramApp.dto.SignUpInput;
import com.instagram.instagramApp.dto.SignUpOutput;
import com.instagram.instagramApp.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private AuthenticationService authenticationService;


    public SignUpOutput signUp(SignUpInput signUpDto) {

        // check if user exists or not in
        User user=iUserRepo.findFirstByEmail(signUpDto.getUserEmail());

        if(user != null){
            throw  new IllegalStateException("user already Exist....Sign in instead...");
        }


        // encryption
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //save the user

        user=new User(
                signUpDto.getUserFirstName(), signUpDto.getUserLastName(),signUpDto.getUserAge(), signUpDto.getUserEmail(),
                encryptedPassword,signUpDto.getUserContact()
        );

        iUserRepo.save(user);

        //token creation and saving
        AuthenticationToken token=new AuthenticationToken(user);
        authenticationService.saveToken(token);

        return new SignUpOutput("user Registered","user Created Successfully");

    }
    public SignInOutput signIn(SignInInput signInDto) {
        // get email
        User user=iUserRepo.findFirstByEmail(signInDto.getUserEmail());
        if(user == null){
            throw  new IllegalStateException("User Invalid !!! ....sign up instead");
        }

        // encrypt the password
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptPassword(signInDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // match it with database encrypted password
        boolean isPasswordValid=encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid){
            throw new IllegalStateException("user invalid ...sign up instead");
        }

        //figure out the token

        AuthenticationToken authenticationToken=authenticationService.getToken(user);

        // set the output response....
        return new SignInOutput("user successfully authenticated ",authenticationToken.getToken());
    }
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested=md5.digest();

        String hash=new String(digested);
        return hash;
    }
}
