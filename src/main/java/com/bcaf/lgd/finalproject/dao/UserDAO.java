package com.bcaf.lgd.finalproject.dao;

import com.bcaf.lgd.finalproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, String> {
//    Optional<com.bcaf.lgd.finalproject.Entity.User> findByEmail(String, email);

    @Query ("SELECT email FROM User WHERE email = :email")
    public User getEmail(@Param("email") String email);
}
