package com.juan.sgcitasrembolsosback.appointment;

import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentReqDTO;
import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentResDTO;
import com.juan.sgcitasrembolsosback.appointment.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Component
@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public String hola(){
        return "Hola mundo";
    }

    @PostMapping("/scheduleAppointment")
    public ResponseEntity<AppointmentResDTO> scheduleAppointment(
            @RequestBody @Valid AppointmentReqDTO request
    )
    {
        appointmentService.scheduleAppointment(request);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("appointments-history/{patient-id}")
    public ResponseEntity<Set<AppointmentResDTO>> getAppointmentsHistory(
            @PathVariable("patient-id") Integer patientId
    ){
        Set<AppointmentResDTO> history = appointmentService.getUserAppointmentsHistory(patientId);
       return  ResponseEntity.ok(history);

    }

    @GetMapping("nexts-appointments/{patient-id}")
    public  ResponseEntity<Set<AppointmentResDTO>> getNextAppointments(
            @PathVariable("patient-id") Integer patientId
    ){
        Set<AppointmentResDTO> history = appointmentService.getNextsAppointments(patientId);
        return  ResponseEntity.ok(history);

    }




}
