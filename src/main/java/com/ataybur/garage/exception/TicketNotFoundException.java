package com.ataybur.garage.exception;

public class TicketNotFoundException extends RuntimeException {
    TicketNotFoundException(Long id) {
        super("Could not find ticket " + id);
    }
}
