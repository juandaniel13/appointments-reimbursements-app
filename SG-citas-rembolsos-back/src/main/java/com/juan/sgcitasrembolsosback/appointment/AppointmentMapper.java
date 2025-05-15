package com.juan.sgcitasrembolsosback.appointment;

import com.juan.sgcitasrembolsosback.appointment.Appointment;
import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentResDTO;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentResDTO appointmentToDTO(Appointment appointment) {
        var dto = AppointmentResDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .healthProviderName(appointment.getHealthProvider().getName())
               // .healthProviderAddress(appointment.getHealthProvider().getLocation().getAddress())
                .build();
        return dto;
    }

}
