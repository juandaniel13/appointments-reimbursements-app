package com.juan.sgcitasrembolsosback.handler.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//include only the non empty atrivutes
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {
    private HttpStatus code;
    private String message;
}
