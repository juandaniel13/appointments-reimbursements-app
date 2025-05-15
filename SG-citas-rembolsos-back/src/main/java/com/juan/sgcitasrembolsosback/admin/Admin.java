package com.juan.sgcitasrembolsosback.admin;

import com.juan.sgcitasrembolsosback.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private User user;



}
