package com.nhnacademy.newcertificate.repository;

import com.nhnacademy.newcertificate.domain.BirthDeathReportResident;
import com.nhnacademy.newcertificate.domain.BirthDeathReportResident.PkBirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, PkBirthDeathReportResident> {
    //출생신고 등록
    //출생신고 수정
    //출생신고 삭제
    //사망신고 등록
    //사망신고 수정
    //사망신고 삭제
    default BirthDeathReportResident registerBirthDeathReport(BirthDeathReportResident report){
        return save(report);
    }
    default BirthDeathReportResident modifyBirthDeathReport(BirthDeathReportResident report){
        return save(report);
    }
    default void removeBirthDeathReport(BirthDeathReportResident report){
        delete(report);
    }
}
