package com.ataybur.garage.advise;

import com.ataybur.garage.exception.VehicleTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class VehicleTypeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(VehicleTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String VehicleTypeNotFoundAdvice(VehicleTypeNotFoundException ex) {
        return ex.getMessage();
    }
}