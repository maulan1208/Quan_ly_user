package com.example.finalexamro37.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String detalMessage;
    private Object error;
    private int code;
    private String moreInformation;
}
