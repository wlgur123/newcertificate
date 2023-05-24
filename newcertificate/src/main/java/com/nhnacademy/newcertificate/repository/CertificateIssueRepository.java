package com.nhnacademy.newcertificate.repository;

import com.nhnacademy.newcertificate.domain.CertificateIssue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateIssueRepository extends JpaRepository<CertificateIssue,Long> {
    @Query("select i from CertificateIssue i where i.certificateConfirmationNumber = :certificateConfirmationNumber")
    CertificateIssue findOne(@Param("certificateConfirmationNumber")Long certificateConfirmationNumber);

    List<CertificateIssue> findByResident_residentRegistrationNumber(@Param("residentRegistrationNumber")String residentRegistrationNumber);
}
