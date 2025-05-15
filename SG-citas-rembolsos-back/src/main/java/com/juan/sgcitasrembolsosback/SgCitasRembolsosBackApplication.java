package com.juan.sgcitasrembolsosback;

import com.juan.sgcitasrembolsosback.healthProvider.HealthProvider;
import com.juan.sgcitasrembolsosback.healthProvider.HealthProviderRepository;
import com.juan.sgcitasrembolsosback.patient.Patient;
import com.juan.sgcitasrembolsosback.patient.PatientRepository;
import com.juan.sgcitasrembolsosback.role.Role;
import com.juan.sgcitasrembolsosback.user.User;
import com.juan.sgcitasrembolsosback.user.UserRepository;
import com.juan.sgcitasrembolsosback.role.UserRole;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class SgCitasRembolsosBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgCitasRembolsosBackApplication.class, args);
    }


    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            PatientRepository patientRepository,
            HealthProviderRepository healthProviderRepository,
            PasswordEncoder passwordEncoder
    ) {
       return  args -> {
           var role = Role.builder()
                   .roleName(UserRole.PATIENT)
                   .build();

           var user = User.builder()
                   .email("juan@gmail.com")
                   .password(passwordEncoder.encode("123456")/*"$2a$12$A0jooP9qYEEncQeu6.OT/eL2b1M9soC/.i2rYTQ7tVQeUeoHI4aEy"*/)
                   .role(role)
                   .build();

          // userRepository.save(user);

           var patient = Patient.builder()
                   .firstName("juan")
                   .email("juan@gmail.com")
                   .user(user)
                   .build();

           patientRepository.save(patient);

           var healthProvider = HealthProvider.builder()
                   .name("sura")
                   .build();
           healthProviderRepository.save(healthProvider);
       };

    }
}
