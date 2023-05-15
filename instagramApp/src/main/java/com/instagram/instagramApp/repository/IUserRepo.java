package com.instagram.instagramApp.repository;

import com.instagram.instagramApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {

    User findFirstByEmail(String userEmail);
}
