package com.juan.sgcitasrembolsosback.refundRequest.service.imp;

import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentResDTO;
import com.juan.sgcitasrembolsosback.handler.RefundRequestNotFoundException;
import com.juan.sgcitasrembolsosback.patient.PatientRepository;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequest;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequestMapper;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequestRepository;
import com.juan.sgcitasrembolsosback.refundRequest.RefundRequestState;
import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestReqDTO;
import com.juan.sgcitasrembolsosback.refundRequest.dto.RefundRequestResDTO;
import com.juan.sgcitasrembolsosback.refundRequest.service.RefundRequestService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RefundRequestImp implements RefundRequestService {

    private final RefundRequestRepository refundRequestRepository;
    private final RefundRequestMapper refundRequestMapper;
    private final PatientRepository patientRepository;


    @Override
    public void RegisterRefundRequest(RefundRequestReqDTO refundRequestDTO) {

        var patient  = patientRepository.findById(refundRequestDTO.getPatientId()).orElseThrow(
                () -> new UsernameNotFoundException("Paciente no encontrado")
        );

        if(patient != null) {
            var refundRequest = RefundRequest.builder()
                    .date(LocalDate.now())
                    .state(RefundRequestState.RECIVED)
                    .patient(patient)
                    .build();
            refundRequestRepository.save(refundRequest);
        }

    }

    @Override
    public void updateRefundRequestState(Integer id, RefundRequestState state) {
        RefundRequest updatedRefundRequest = refundRequestRepository.findById(id).
                orElseThrow(() -> new RefundRequestNotFoundException("No ha sido encontrada la solicitud con id: " + id)); //ADD exception
        updatedRefundRequest.setState(state);
        refundRequestRepository.save(updatedRefundRequest);
    }

    @Override
    public Set<RefundRequestResDTO> getUserRefundRequestsHistory(Integer id) {
        return refundRequestRepository.findAllARefundRequestsByPatientId(id)
                .stream().map(refundRequestMapper::refundRequestToRefundRequestDTO)
                .collect(Collectors.toSet());
    }
}
