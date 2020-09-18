package com.bcaf.lgd.finalproject.dao;

import com.bcaf.lgd.finalproject.Entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyDAO extends JpaRepository<Agency, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM agency WHERE owner =:id ")
    Agency getAgencyByUserId(@Param("id") String id);
}
