package com.instagram.instagramApp.repository;

import com.instagram.instagramApp.Model.AuthenticationToken;
import com.instagram.instagramApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken findByUser(User user);
}
