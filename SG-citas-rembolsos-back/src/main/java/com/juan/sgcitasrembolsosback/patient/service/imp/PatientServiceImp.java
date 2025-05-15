package com.juan.sgcitasrembolsosback.patient.service.imp;

import com.juan.sgcitasrembolsosback.handler.PatientNotFoundException;
import com.juan.sgcitasrembolsosback.patient.Patient;
import com.juan.sgcitasrembolsosback.patient.PatientMapper;
import com.juan.sgcitasrembolsosback.patient.PatientRepository;
import com.juan.sgcitasrembolsosback.patient.dto.PatientResDTO;
import com.juan.sgcitasrembolsosback.patient.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImp implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientResDTO getPatientDetails(Integer id) {
        Patient foundPatient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("No han sido encontrados los datos del pasciente con id: " + id));
        return patientMapper.patientToDTO(foundPatient);
    }

    @Override
    public PatientResDTO getPatientByEmail(String email) {
        Patient foundPatient =  patientRepository.findByEmail(email)
                .orElseThrow(
                        () -> new PatientNotFoundException("El paciente no ha sido encontrado")
                );
        return  patientMapper.patientToDTO(foundPatient);
    }
}
