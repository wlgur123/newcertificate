package com.nhnacademy.newcertificate.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.newcertificate.config.RootConfig;
import com.nhnacademy.newcertificate.config.WebConfig;
import com.nhnacademy.newcertificate.domain.Household;
import java.time.LocalDateTime;
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
class HouseholdRepositoryTest {
    @Autowired
    HouseholdRepository householdRepository;
    @Test
    void 세대등록(){
        Household household = new Household();
        household.setHouseholdSerialNumber(1234);
        household.setHouseholdCompositionDate(LocalDateTime.now());
        household.setHouseholdCompositionReasonCode("001");
        household.setCurrentHouseMovementAddress("Address");
        Household savedHousehold = householdRepository.registerHousehold(household);
        assertNotNull(savedHousehold);
    }
    @Test
    void 세대삭제(){
        Household household = new Household();
        household.setHouseholdSerialNumber(1234);
        household.setHouseholdCompositionDate(LocalDateTime.now());
        household.setHouseholdCompositionReasonCode("001");
        household.setCurrentHouseMovementAddress("Address");
        Household savedHousehold = householdRepository.registerHousehold(household);
        householdRepository.removeHousehold(savedHousehold);
        assertFalse(householdRepository.findById(savedHousehold.getHouseholdSerialNumber()).isPresent());

    }
}