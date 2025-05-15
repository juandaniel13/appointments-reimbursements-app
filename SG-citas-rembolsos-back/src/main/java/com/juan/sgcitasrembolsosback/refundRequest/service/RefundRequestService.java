package com.juan.sgcitasrembolsosback.refundRequest.service;

import com.juan.sgcitasrembolsosback.refundRequest.RefundRequest;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequestState;
import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestReqDTO;
import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestResDTO;

import java.util.Set;

public interface RefundRequestService {
    void RegisterRefundRequest(RefundRequestReqDTO refundRequest);

    void updateRefundRequestState(Integer id, RefundRequestState state);

    Set<RefundRequestResDTO> getUserRefundRequestsHistory(Integer id);

}
