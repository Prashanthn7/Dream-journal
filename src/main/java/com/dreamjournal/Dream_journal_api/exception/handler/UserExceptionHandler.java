package com.dreamjournal.Dream_journal_api.exception.handler;

import com.dreamjournal.Dream_journal_api.exception.UserNotFoundByIdException;
import com.dreamjournal.Dream_journal_api.util.ResponseBuilder;
import com.dreamjournal.Dream_journal_api.util.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> getMessage(UserNotFoundByIdException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage());
    }
}
