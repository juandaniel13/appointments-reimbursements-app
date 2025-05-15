package com.juan.sgcitasrembolsosback.handler;

import com.juan.sgcitasrembolsosback.handler.dto.ExceptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /*Este es el exception handler*/
    /*Cada vez que una localNotFound exception ocurra, esta será interceptada*/
    @ExceptionHandler(RefundRequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //404
    public ResponseEntity<ExceptionResponse> RefundRequestNotFound(RefundRequestNotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse( HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //404
    public ResponseEntity<ExceptionResponse> PatientNotFound(PatientNotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse( HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TimeOverlapException.class)
    @ResponseStatus(HttpStatus.CONFLICT) //404
    public ResponseEntity<ExceptionResponse> TimeOverlap(TimeOverlapException exception) {
        ExceptionResponse response = new ExceptionResponse( HttpStatus.CONFLICT,exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
       /*Retuns a list with all exceptions */
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        //return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }


}
