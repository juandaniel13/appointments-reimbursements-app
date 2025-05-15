package com.juan.sgcitasrembolsosback.auth;

import com.juan.sgcitasrembolsosback.security.JwtService;
import com.juan.sgcitasrembolsosback.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var user =  userRepository.findByEmail(authRequest.getEmail()).get();
        claims.put("fullName", user.getUsername());
        var jwtToken = jwtService.generateToken(claims, user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();


    }
}
