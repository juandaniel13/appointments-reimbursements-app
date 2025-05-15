package com.juan.sgcitasrembolsosback.refundRequest;

import com.juan.sgcitasrembolsosback.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface RefundRequestRepository  extends JpaRepository<RefundRequest, Integer> {

    @Query("SELECT R FROM RefundRequest R where R.patient.id = :id ")
    Set<RefundRequest> findAllARefundRequestsByPatientId(Integer id);
}
