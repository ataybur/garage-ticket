package com.ataybur.garage.advise;

import com.ataybur.garage.exception.GarageHasNoProperSlotsException;
import com.ataybur.garage.exception.GarageIsFullException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GarageAdvice {

    @ResponseBody
    @ExceptionHandler(GarageIsFullException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String GarageIsFullAdvice(GarageIsFullException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(GarageHasNoProperSlotsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String GarageIsFullAdvice(GarageHasNoProperSlotsException ex) {
        return ex.getMessage();
    }
}