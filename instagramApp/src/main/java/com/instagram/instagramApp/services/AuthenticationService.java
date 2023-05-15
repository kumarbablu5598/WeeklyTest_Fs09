package com.instagram.instagramApp.services;

import com.instagram.instagramApp.Model.AuthenticationToken;
import com.instagram.instagramApp.Model.User;
import com.instagram.instagramApp.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private ITokenRepo iTokenRepo;

    public void saveToken(AuthenticationToken token){
        iTokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return iTokenRepo.findByUser(user);
    }
}
