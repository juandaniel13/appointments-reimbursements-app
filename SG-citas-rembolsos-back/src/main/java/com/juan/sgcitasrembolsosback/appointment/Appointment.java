package com.juan.sgcitasrembolsosback.appointment;

import com.juan.sgcitasrembolsosback.healthProvider.HealthProvider;
import com.juan.sgcitasrembolsosback.location.Location;
import com.juan.sgcitasrembolsosback.patient.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "health_provider_id")
    private HealthProvider healthProvider;

    @Embedded
    private Location location;


}
