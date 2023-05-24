package com.nhnacademy.newcertificate.service;

import com.nhnacademy.newcertificate.domain.CertificateIssue;
import com.nhnacademy.newcertificate.domain.Resident;
import com.nhnacademy.newcertificate.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.newcertificate.repository.CertificateIssueRepository;
import com.nhnacademy.newcertificate.repository.FamilyRelationshipRepository;
import com.nhnacademy.newcertificate.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.newcertificate.repository.HouseholdRepository;
import com.nhnacademy.newcertificate.repository.ResidentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResidentService {
    private final ResidentRepository residentRepository;
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final HouseholdRepository householdRepository;
    private final CertificateIssueRepository certificateIssueRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
    public Resident findResidentByName(String name){
        return residentRepository.findByName(name);
    }

    public List<CertificateIssue> findByRegistrationNo(String registrationNo){
        return certificateIssueRepository.findByResident_residentRegistrationNumber(registrationNo);
    }


}
