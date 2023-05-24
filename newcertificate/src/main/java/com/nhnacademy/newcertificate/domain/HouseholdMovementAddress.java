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
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {

    @EmbeddedId
    private PkHouseholdMovementAddress pk;

    @Column(name = "household_movement_address",nullable = false)
    private String houseMovementAddress;
    @Column(name = "last_address_yn",nullable = false)
    private String lastAddressYn;

    @NoArgsConstructor
    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    @AllArgsConstructor
    public static class PkHouseholdMovementAddress implements Serializable {

        @Column(name = "house_movement_report_date")
        private LocalDateTime houseMovementReportDate;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "household_serial_number")
        private Household household;
    }
}

