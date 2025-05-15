package com.juan.sgcitasrembolsosback.patient;

import com.juan.sgcitasrembolsosback.patient.dto.PatientResDTO;
import com.juan.sgcitasrembolsosback.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("details/{patient-id}")
    public ResponseEntity<PatientResDTO> getPatientDetails(@PathVariable("patient-id") int patientId) {
        PatientResDTO patientResDTO = patientService.getPatientDetails(patientId);
        return ResponseEntity.ok(patientResDTO);
    }

    @GetMapping("{patient-email}")
    public ResponseEntity<PatientResDTO> getPatientByEmail(@PathVariable("patient-email") String patientEmail) {
        PatientResDTO patientResDTO = patientService.getPatientByEmail(patientEmail);
        return ResponseEntity.ok(patientResDTO);
    }



}
