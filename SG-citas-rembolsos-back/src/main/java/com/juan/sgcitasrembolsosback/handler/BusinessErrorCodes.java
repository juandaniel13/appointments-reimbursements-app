package com.juan.sgcitasrembolsosback.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum BusinessErrorCodes {
    NO_CODE(0, "No code",  NOT_IMPLEMENTED),
    INCORRECT_CURRENT_PASSWORD(300, "Current password is incorrect", BAD_REQUEST),
    NEW_PASSWORD_DOES_NOT_MATCH(301, "The new password does not match", BAD_REQUEST),
    ACCOUNT_LOCKED(302, "User account is locked", FORBIDDEN),
    ACCOUNT_DISABLED(303, "User account is disabled", FORBIDDEN),
    BAD_CREDENTIALS(304, "Login and / or password is incorrect ", FORBIDDEN),
    REQUEST_NOT_FOUND(404, "The request was not found", NOT_FOUND);

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;
}
