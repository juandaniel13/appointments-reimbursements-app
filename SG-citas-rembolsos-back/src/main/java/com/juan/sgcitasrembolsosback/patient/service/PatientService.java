package com.juan.sgcitasrembolsosback.patient.service;

import com.juan.sgcitasrembolsosback.patient.Patient;
import com.juan.sgcitasrembolsosback.patient.dto.PatientResDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientService {
    PatientResDTO getPatientDetails(Integer id);

    PatientResDTO getPatientByEmail(String email);
}
