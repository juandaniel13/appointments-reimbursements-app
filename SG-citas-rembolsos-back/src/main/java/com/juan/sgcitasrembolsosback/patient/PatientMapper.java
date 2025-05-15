package com.juan.sgcitasrembolsosback.patient;

import com.juan.sgcitasrembolsosback.patient.dto.PatientResDTO;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientResDTO patientToDTO(Patient patient) {
        var dto = PatientResDTO.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .sex(patient.getSex())
                .tel(patient.getTel())
                .age(patient.getAge())
                .RH(patient.getRH())
                .height(patient.getHeight())
                .weight(patient.getWeight())
                .address(patient.getAddress())
                .build();
        return dto;
    }

    public Patient dtoToPatient(PatientResDTO dto) {
        var patient = Patient.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .RH(dto.getRH())
                .sex(dto.getSex())
                .tel(dto.getTel())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .age(dto.getAge())
                .build();
        return patient;
    }
}
