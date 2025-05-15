package com.juan.sgcitasrembolsosback.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PatientResDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer tel;
    private Integer sex;
    private String address;
    private Integer age;
    private String RH;
    private Double height;
    private Double weight;

}
