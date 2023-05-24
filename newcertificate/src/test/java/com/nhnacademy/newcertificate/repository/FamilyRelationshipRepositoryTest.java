package com.nhnacademy.newcertificate.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.newcertificate.config.RootConfig;
import com.nhnacademy.newcertificate.config.WebConfig;
import com.nhnacademy.newcertificate.domain.FamilyRelationship;
import com.nhnacademy.newcertificate.domain.Resident;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
class FamilyRelationshipRepositoryTest {
    @Autowired
    FamilyRelationshipRepository familyRelationshipRepository;
    @Autowired
    ResidentRepository residentRepository;

    @Test
    void 가족관계조회(){
        Resident resident = residentRepository.findByName("남기준");
        List<FamilyRelationship> relationships= familyRelationshipRepository.findByPkResident(resident);

        for(FamilyRelationship relationship : relationships){
            log.info(relationship.getFamilyRelationshipCode());
        }
    }

}