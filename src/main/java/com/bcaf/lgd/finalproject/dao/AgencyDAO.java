package com.bcaf.lgd.finalproject.dao;

import com.bcaf.lgd.finalproject.Entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyDAO extends JpaRepository<Agency, String> {
}
