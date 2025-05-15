package com.juan.sgcitasrembolsosback.appointment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class AppointmentResDTO {
    private Integer id;
    private LocalDateTime date;
    private String healthProviderName;
    private String healthProviderAddress;
}
