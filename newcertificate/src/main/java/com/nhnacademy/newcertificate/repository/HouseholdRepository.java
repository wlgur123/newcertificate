package com.nhnacademy.newcertificate.repository;

import com.nhnacademy.newcertificate.domain.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository <Household,Integer> {
    //세대 등록
    //세대 삭제
    default Household registerHousehold(Household household){
        return save(household);
    }

    default void removeHousehold(Household household){
        delete(household);
    }
}
