package com.nhnacademy.newcertificate.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "household")
public class Household{
    @Id
    @Column(name = "household_serial_number")
    private int householdSerialNumber;
    @Column(name = "household_composition_date",nullable = false)
    private LocalDateTime householdCompositionDate;
    @Column(name = "household_composition_reason_code",nullable = false)
    private String householdCompositionReasonCode;
    @Column(name = "current_house_movement_address",nullable = false)
    private String currentHouseMovementAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "resident_serial_number",name = "household_resident_serial_number")
    private Resident resident;

}