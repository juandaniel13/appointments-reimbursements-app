package com.juan.sgcitasrembolsosback.refundRequest;

import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestReqDTO;
import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestResDTO;
import com.juan.sgcitasrembolsosback.refundRequest.service.RefundRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("refund-request")
@RequiredArgsConstructor
public class RefundRequestController {

    private final RefundRequestService refundRequestService;

    @PostMapping("register-refund-request")
    public ResponseEntity<String> registerRefundRequest(@RequestBody @Valid RefundRequestReqDTO request) {

        refundRequestService.RegisterRefundRequest(request);

        return ResponseEntity.ok("Refund request registered");

    }

    @PutMapping("update-status/{id}")
    public ResponseEntity<String> updateStatus(
            @PathVariable Integer id ,
            @RequestBody @Valid RefundRequestReqDTO request) {

        refundRequestService.updateRefundRequestState(id, request.getState());
        return ResponseEntity.ok("Refund request registered");
    }

    @GetMapping("find-refund-requests/{id}")
    public ResponseEntity<Set<RefundRequestResDTO>> findRefundRequests(
            @PathVariable Integer patiendId
    ) {
     Set<RefundRequestResDTO> requests  = refundRequestService.getUserRefundRequestsHistory(patiendId);
        return ResponseEntity.ok(requests);
    }
}
