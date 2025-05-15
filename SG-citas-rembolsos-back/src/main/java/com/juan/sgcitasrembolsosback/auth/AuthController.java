package com.juan.sgcitasrembolsosback.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/authorization")
    public ResponseEntity<AuthResponse> authorize(
            @RequestBody AuthRequest authRequest
    ){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaxdxdxd");
        return ResponseEntity.ok(authService.authenticate(authRequest));

    }
}
