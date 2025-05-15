package com.juan.sgcitasrembolsosback.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthRequest {
    @Email(message = "Email in not formatted")
    @NotBlank(message = "lastname is mandatory")
    @NotEmpty(message = "email is mandatory")
    private String email;
    @Size(min = 8, message = "Password should be 8 characters long minimum")
    private String password;
}
