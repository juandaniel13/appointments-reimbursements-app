package com.juan.sgcitasrembolsosback.patient;

import com.juan.sgcitasrembolsosback.appointment.Appointment;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequest;
import com.juan.sgcitasrembolsosback.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer tel;
    private Integer sex;
    private String address;
    private Integer age;
    private String RH;
    private Double height;
    private Double weight;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany (mappedBy = "patient")
    Set<RefundRequest> refundRequests;

    @OneToMany(mappedBy = "patient")
    Set<Appointment> appointments;
}
