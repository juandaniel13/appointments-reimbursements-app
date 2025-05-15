package com.juan.sgcitasrembolsosback.refundRequest.dto;

import com.juan.sgcitasrembolsosback.refundRequest.RefundRequestState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class RefundRequestReqDTO {
    private Integer patientId;
    private RefundRequestState state;
}
