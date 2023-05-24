package com.nhnacademy.newcertificate.repository;

import com.nhnacademy.newcertificate.domain.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, String> {

    //PK를 이용해 Resident 하나 찾기
    @Query("select r from Resident r where r.residentSerialNumber = :id")
    Resident findOne(@Param("id")String id);


    @Query("select r from Resident r where r.name = :name")
    Resident findByName(@Param("name")String name);

}
