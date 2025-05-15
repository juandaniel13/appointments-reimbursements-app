package com.juan.sgcitasrembolsosback.refundRequest;

import com.juan.sgcitasrembolsosback.patient.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefundRequest {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate date;
    private RefundRequestState state;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
