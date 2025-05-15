package com.juan.sgcitasrembolsosback.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository  extends JpaRepository<Patient, Integer> {
    @Query("SELECT P FROM Patient  P WHERE  P.email = :email")
    Optional<Patient> findByEmail(@Param("email") String email);
}
