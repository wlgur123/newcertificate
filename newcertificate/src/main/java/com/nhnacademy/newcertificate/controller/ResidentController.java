package com.nhnacademy.newcertificate.controller;

import com.nhnacademy.newcertificate.domain.BirthDeathReportResident;
import com.nhnacademy.newcertificate.domain.BirthDeathReportResident.PkBirthDeathReportResident;
import com.nhnacademy.newcertificate.domain.CertificateIssue;
import com.nhnacademy.newcertificate.domain.FamilyRelationship;
import com.nhnacademy.newcertificate.domain.Resident;
import com.nhnacademy.newcertificate.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.newcertificate.repository.CertificateIssueRepository;
import com.nhnacademy.newcertificate.repository.FamilyRelationshipRepository;
import com.nhnacademy.newcertificate.service.ResidentService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/residents")
@Slf4j
@RequiredArgsConstructor
public class ResidentController {
    private final ResidentService residentService;
    private final CertificateIssueRepository certificateIssueRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    Resident resident;
    @PostMapping("/login")
    public String login(@RequestParam("name")String name, Model model){
         resident = residentService.findResidentByName(name);
//         log.info(resident.getName(),resident.getResidentSerialNumber());
        model.addAttribute("resident",resident);
        return "resident";
    }

    @GetMapping("/issuelist")
    public String getCertificateIssues(Model model){
        List<CertificateIssue> certificateIssues = certificateIssueRepository.findByResident_residentRegistrationNumber(
            resident.getResidentRegistrationNumber());
        model.addAttribute("certificateIssues",certificateIssues);
        return "issueList";
    }

    @GetMapping("/familyrelationship")
    public String getFamilyrelationship(Model model){
        List<FamilyRelationship> familyRelationships = familyRelationshipRepository.findByPkResident(resident);
        model.addAttribute("familyRelationships",familyRelationships);
        return "familyrelationship";
    }

    @GetMapping("/birth")
    public String birth(){
        return "birth";
    }
    @PostMapping("/birthReport")
    public void registerBirthReport(@RequestParam String birthDeathTypeCode,
        @RequestParam int residentSerialNumber,
        @RequestParam int reportResidentSerialNumber,
        @RequestParam LocalDateTime birthDeathReportDate,
        @RequestParam String birthReportQualificationsCode,
        @RequestParam String emailAddress,
        @RequestParam String phoneNumber){
        BirthDeathReportResident.PkBirthDeathReportResident pk = new PkBirthDeathReportResident();
        pk.setBirthDeathTypeCode(birthDeathTypeCode);
        pk.setResidentSerialNumber(residentSerialNumber);
        pk.setResident(resident);

        BirthDeathReportResident report = new BirthDeathReportResident();
        report.setPk(pk);
        report.setBirthDateReportDate(birthDeathReportDate);
        report.setBirthReportQualificationsCode(birthReportQualificationsCode);
        report.setEmailAddress(emailAddress);
        report.setPhoneNumber(phoneNumber);
        birthDeathReportResidentRepository.registerBirthDeathReport(report);
    }

    @GetMapping("/death")
    public String death(){
        return "death";
    }
    @PostMapping("/deathReport")
    public void deathReport(@RequestParam String birthDeathTypeCode,
        @RequestParam int residentSerialNumber,
        @RequestParam int reportResidentSerialNumber,
        @RequestParam LocalDateTime birthDeathReportDate,
        @RequestParam String deathReportQualificationsCode,
        @RequestParam String emailAddress,
        @RequestParam String phoneNumber){
        BirthDeathReportResident.PkBirthDeathReportResident pk2 = new PkBirthDeathReportResident();
        pk2.setBirthDeathTypeCode(birthDeathTypeCode);
        pk2.setResidentSerialNumber(residentSerialNumber);
        pk2.setResident(resident);

        BirthDeathReportResident report = new BirthDeathReportResident();
        report.setPk(pk2);
        report.setBirthDateReportDate(birthDeathReportDate);
        report.setBirthReportQualificationsCode(deathReportQualificationsCode);
        report.setEmailAddress(emailAddress);
        report.setPhoneNumber(phoneNumber);
        birthDeathReportResidentRepository.registerBirthDeathReport(report);
    }
}
