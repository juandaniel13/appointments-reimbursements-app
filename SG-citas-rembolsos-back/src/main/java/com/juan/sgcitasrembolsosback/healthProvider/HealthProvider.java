package com.juan.sgcitasrembolsosback.healthProvider;

import com.juan.sgcitasrembolsosback.appointment.Appointment;
import com.juan.sgcitasrembolsosback.location.Location;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthProvider {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "healthProvider")
    private Set<Appointment> appointments;
}
