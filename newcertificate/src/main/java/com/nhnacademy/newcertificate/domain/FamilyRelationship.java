package com.nhnacademy.newcertificate.domain;

import java.io.Serializable;
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
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private PkFamilyRelationship pk;
    @Column(name = "family_relationship_code",nullable = false)
    private String familyRelationshipCode;

    @Embeddable
    @Getter @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PkFamilyRelationship implements Serializable {
        @Column(name = "family_resident_serial_number")
        private int familyResidentSerialNumber;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(referencedColumnName = "resident_serial_number",name = "base_resident_serial_number")
        private Resident resident;
    }
}