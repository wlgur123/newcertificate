package com.nhnacademy.newcertificate.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {
    @EmbeddedId
    private PkHouseholdCompositionResident pk;
    @Column(name = "report_date", nullable = false)
    private LocalDate reportDate;
    @Column(name = "household_relationship_code", nullable = false)
    private String householdRelationCode;
    @Column(name = "household_composition_change_reason_code",nullable = false)
    private String householdCompositionChangeReasonCode;

    @NoArgsConstructor
    @Getter @Setter
    @Embeddable
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class PkHouseholdCompositionResident implements Serializable {
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "household_serial_number")
        private Household household;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "resident_serial_number")
        private Resident resident;
    }
}