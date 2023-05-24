package com.nhnacademy.newcertificate.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {
    @EmbeddedId
    private PkBirthDeathReportResident pk;
    @Column(name = "birth_date_report_date",nullable = false)
    private LocalDateTime birthDateReportDate;
    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;
    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Embeddable
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class PkBirthDeathReportResident implements Serializable {
        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;

        @Column(name = "resident_serial_number")
        private int residentSerialNumber;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(referencedColumnName = "resident_serial_number", name = "report_resident_serial_number")
        private Resident resident;
    }
}