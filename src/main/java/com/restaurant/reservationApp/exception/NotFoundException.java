package com.restaurant.reservationApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No record with that id found")
public class NotFoundException extends RuntimeException {
}
