package com.bcaf.lgd.finalproject.dao;

import com.bcaf.lgd.finalproject.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleDAO extends JpaRepository<Role, String> {
    @Query(nativeQuery = true,value="SELECT * FROM role WHERE role like %:role% ")
    Role getIdByRole(@Param("role") String role);

    @Query(nativeQuery = true,value="SELECT * FROM role WHERE id like %:id% ")
    List<Role> getNameByRole(@Param("id") String id);
}
