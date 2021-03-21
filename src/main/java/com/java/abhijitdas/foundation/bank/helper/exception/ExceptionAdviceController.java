package com.java.abhijitdas.foundation.bank.helper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorMessage errMsg = new ErrorMessage(HttpStatus.NOT_FOUND);
        errMsg.setMessage(ex.getMessage());
        errMsg.setError("Entity NOT Found");
        errMsg.setTimestamp(LocalDateTime.now());

        return  new ResponseEntity<>(errMsg, errMsg.getHttpStatus());

    }
}
