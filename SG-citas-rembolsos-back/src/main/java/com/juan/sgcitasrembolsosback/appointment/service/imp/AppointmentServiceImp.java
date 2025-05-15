package com.juan.sgcitasrembolsosback.appointment.service.imp;

import com.juan.sgcitasrembolsosback.appointment.Appointment;
import com.juan.sgcitasrembolsosback.appointment.AppointmentMapper;
import com.juan.sgcitasrembolsosback.appointment.AppointmentRepository;
import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentReqDTO;
import com.juan.sgcitasrembolsosback.appointment.dto.AppointmentResDTO;
import com.juan.sgcitasrembolsosback.appointment.service.AppointmentService;
import com.juan.sgcitasrembolsosback.handler.TimeOverlapException;
import com.juan.sgcitasrembolsosback.healthProvider.HealthProvider;
import com.juan.sgcitasrembolsosback.healthProvider.HealthProviderRepository;
import com.juan.sgcitasrembolsosback.location.Location;
import com.juan.sgcitasrembolsosback.patient.Patient;
import com.juan.sgcitasrembolsosback.patient.PatientRepository;
import com.juan.sgcitasrembolsosback.role.Role;
import com.juan.sgcitasrembolsosback.role.UserRole;
import com.juan.sgcitasrembolsosback.user.User;
import com.juan.sgcitasrembolsosback.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImp implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final HealthProviderRepository healthProviderRepository;
    private final PatientRepository patientRepository;

    private boolean isTheScheduleAvailable(Appointment appointment) {
        Optional<Appointment> timeOverlap = appointmentRepository.findAppointementByDateTimeAndHealthProviderAddressAndRoom(
                appointment.getDate(),
                appointment.getLocation().getAddress(),
                appointment.getLocation().getRoom()
        );
        if (timeOverlap.isPresent()) {
            return false; //hay cita asignada
        }
        return true; //no hay cita asignada
    }

    @Override
    public void scheduleAppointment(AppointmentReqDTO appointmentReq) {
        Optional<HealthProvider> healthProviderOpt = healthProviderRepository.findByName(appointmentReq.getHealthProviderName());

        if (healthProviderOpt.isPresent()) {
            HealthProvider healthProvider = healthProviderOpt.get();

            Optional<Patient> patient = patientRepository.findById(appointmentReq.getPatientId());

            if(patient.isPresent()) {
                Appointment appointment = Appointment.builder()
                        .patient(patient.get())
                        .date(appointmentReq.getDate())
                        .healthProvider(healthProvider)
                        .date(appointmentReq.getDate())
                        .location(Location.builder()
                                .address(appointmentReq.getAddress())
                                .room(appointmentReq.getRoom())
                                .build())
                        .build();

                if (isTheScheduleAvailable(appointment)) {
                    appointmentRepository.save(appointment);
                } else {
                    throw new TimeOverlapException("Ya hay una cita asignada en este horario");
                }
            }else{
                throw new EntityNotFoundException("Paciente no encontrado");
            }

           /* var role = Role.builder()
                    .roleName(UserRole.PATIENT)
                    .build();

            var user = User.builder()
                    .email("juan@gmail.com")
                    .password("$2a$12$A0jooP9qYEEncQeu6.OT/eL2b1M9soC/.i2rYTQ7tVQeUeoHI4aEy")
                    .role(role)
                    .build();

            var patient = Patient.builder()
                    .firstName("juan")
                    .user(user)
                    .build();*/


        } else {
            throw new EntityNotFoundException("Proveedor de salud no encontrado");
        }
    }


    @Override
    public Set<AppointmentResDTO> getUserAppointmentsHistory(Integer id) {
        return appointmentRepository.findAllApointmetsByPatientId(id)
                .stream().map(appointmentMapper::appointmentToDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AppointmentResDTO> getNextsAppointments(Integer id) {
        return appointmentRepository.findNextAppointmentsByPatientId(id).stream()
                .map(appointmentMapper::appointmentToDTO)
                .collect(Collectors.toSet());
    }

}
