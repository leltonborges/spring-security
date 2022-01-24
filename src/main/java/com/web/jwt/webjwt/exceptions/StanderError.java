package com.web.jwt.webjwt.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class StanderError {
    private String message;
    private String error;
    private HttpStatus status;
    private Long timestamp;
    private String path;
}
