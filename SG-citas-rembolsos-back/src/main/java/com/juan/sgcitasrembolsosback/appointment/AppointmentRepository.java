package com.juan.sgcitasrembolsosback.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT A FROM Appointment A where A.patient.id = :id ")
    Set<Appointment> findAllApointmetsByPatientId(@Param("id") Integer id);

    @Query("SELECT A FROM Appointment  A where A.date = :date AND A.location.address = :address AND A.location.room = :room")
    Optional<Appointment> findAppointementByDateTimeAndHealthProviderAddressAndRoom(
            @Param("date") LocalDateTime date,
            @Param("address") String address,
            @Param("room") Integer room);

    @Query("SELECT A FROM Appointment A WHERE A.patient.id = :id AND A.date > CURRENT_TIMESTAMP")
    Set<Appointment> findNextAppointmentsByPatientId(@Param("id") Integer id);
}
