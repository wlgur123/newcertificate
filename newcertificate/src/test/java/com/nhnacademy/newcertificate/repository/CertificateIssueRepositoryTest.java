package com.nhnacademy.newcertificate.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.newcertificate.config.RootConfig;
import com.nhnacademy.newcertificate.config.WebConfig;
import com.nhnacademy.newcertificate.domain.CertificateIssue;
import com.nhnacademy.newcertificate.domain.Resident;
import java.time.LocalDateTime;
import net.bytebuddy.asm.Advice.Unused;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
class CertificateIssueRepositoryTest {
    @Autowired
    CertificateIssueRepository certificateIssueRepository;
    @Autowired
    ResidentRepository residentRepository;
    @Test
    void 발급기록조회(){
        Resident resident = new Resident();
        resident.setResidentSerialNumber("10");
        resident.setName("안지혁");
        resident.setResidentRegistrationNumber("990407-1111111");
        resident.setGenderCode("남");
        resident.setBirthDate(LocalDateTime.now());
        resident.setBirthPlaceCode("mokpo");
        resident.setRegistrationBaseAddress("mokpo");
        residentRepository.save(resident);
        CertificateIssue certificateIssue = new CertificateIssue();
        certificateIssue.setCertificateConfirmationNumber(12345L);
        certificateIssue.setResident(resident);
        certificateIssue.setCertificateTypeCode("주민등록등본");
        certificateIssue.setCertificateIssueDate(LocalDateTime.now());
        certificateIssueRepository.save(certificateIssue);
        assertThat(certificateIssueRepository.findByResident_residentRegistrationNumber("990407-1111111").size()).isEqualTo(1);
    }

}