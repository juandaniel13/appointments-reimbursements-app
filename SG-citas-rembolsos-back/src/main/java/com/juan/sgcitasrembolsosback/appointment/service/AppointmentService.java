package com.juan.sgcitasrembolsosback.appointment.service;

import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentReqDTO;
import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface AppointmentService {


   void scheduleAppointment(AppointmentReqDTO appointmentReq);

   Set<AppointmentResDTO> getUserAppointmentsHistory(Integer id);

   Set<AppointmentResDTO> getNextsAppointments(Integer id);



}
