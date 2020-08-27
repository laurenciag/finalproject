package com.bcaf.lgd.finalproject.dao;

import com.bcaf.lgd.finalproject.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, String> {
}
