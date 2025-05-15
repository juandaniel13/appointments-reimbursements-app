package com.juan.sgcitasrembolsosback.refundRequest.dto;

import com.juan.sgcitasrembolsosback.patient.Patient;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequestState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class RefundRequestResDTO {

    private Integer id;
    private LocalDate date;
    private RefundRequestState state;
    private Integer patientId;
}
