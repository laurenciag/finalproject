package com.bcaf.lgd.finalproject.dao;

import com.bcaf.lgd.finalproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

    @Query (nativeQuery = true,value="SELECT * FROM user WHERE email =:email ")
    User getEmail(@Param("email") String email);

    @Query (nativeQuery = true, value = "SELECT first_name,last_name FROM user WHERE id =")
    User getData(@Param("id") String id);

    @Query (nativeQuery = true, value = "SELECT * FROM user where id =")
    User getDataById(@Param("id") String id);
}
