package com.nhnacademy.newcertificate.repository;

import com.nhnacademy.newcertificate.domain.FamilyRelationship;
import com.nhnacademy.newcertificate.domain.FamilyRelationship.PkFamilyRelationship;
import com.nhnacademy.newcertificate.domain.Resident;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, PkFamilyRelationship> {
    //등록
    //수정
    //삭제
    List<FamilyRelationship> findByPkResident(@Param("resident") Resident resident);
}
