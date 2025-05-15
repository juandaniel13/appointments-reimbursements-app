package com.juan.sgcitasrembolsosback.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class AppointmentReqDTO {
    private LocalDateTime date;
    private String healthProviderName;
    private String healthProviderAddress;
    private String address;
    private Integer room;
    private Integer patientId;
}
