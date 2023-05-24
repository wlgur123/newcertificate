package com.nhnacademy.newcertificate.repository;

import com.nhnacademy.newcertificate.domain.HouseholdCompositionResident;
import com.nhnacademy.newcertificate.domain.HouseholdCompositionResident.PkHouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, PkHouseholdCompositionResident> {
    //세대 전입 주소 등록
    //세대 전입 주소 수정
    //세대 전입 주소 삭제
    default HouseholdCompositionResident registerHouseholdCompositionResident(HouseholdCompositionResident resident) {
        return save(resident);
    }

    default HouseholdCompositionResident modifyHouseholdCompositionResident(HouseholdCompositionResident resident) {
        return save(resident);
    }

    default void removeHouseholdCompositionResident(HouseholdCompositionResident resident) {
        delete(resident);
    }
}
