package com.juan.sgcitasrembolsosback.location;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

//@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Location {
 /*   @Id
    @GeneratedValue
    private String id;*/
    private String address;
    private Integer room;
    private String description;



}
