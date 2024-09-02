package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException plantException){
        log.error("Exception occured", plantException);
        PlantErrorResponse response = new PlantErrorResponse(plantException.getHttpStatus().value(),plantException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response,plantException.getHttpStatus());
    }


    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception) {
        log.error("Exception occured", exception);
        PlantErrorResponse response = new PlantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
