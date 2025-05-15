package com.juan.sgcitasrembolsosback.refundRequest;

import com.juan.sgcitasrembolsosback.appointment.Appointment;
import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentResDTO;
import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestResDTO;
import org.springframework.stereotype.Controller;

@Controller
public class RefundRequestMapper

{
    public RefundRequestResDTO refundRequestToRefundRequestDTO(RefundRequest refundRequest) {
        var dto = RefundRequestResDTO.builder()
                .id(refundRequest.getId())
                .date(refundRequest.getDate())
                .state(refundRequest.getState())
               // .patientId(refundRequest.getPatient().getId())
                .build();
        return dto;
    }
}
