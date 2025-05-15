package com.juan.sgcitasrembolsosback.healthProvider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthProviderRepository  extends JpaRepository<HealthProvider, Integer> {

    Optional<HealthProvider> findByName(String name);

}
