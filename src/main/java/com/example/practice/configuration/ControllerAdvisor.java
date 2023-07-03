package com.example.practice.configuration;

import com.example.practice.exceptions.DocumentNumberAlreadyExistsException;
import com.example.practice.exceptions.EmailAlreadyExistsException;
import com.example.practice.exceptions.NoDataFoundException;
import com.example.practice.exceptions.RoleNotFoundException;
import com.example.practice.exceptions.UserNotFoundException;
import com.example.practice.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        Map<String, String> mapException = new HashMap<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                mapException.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(mapException);
    }

    @ExceptionHandler(DocumentNumberAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleDocumentNumberAlreadyExistsException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.DOCUMENT_ALREADY_EXISTS_MESSAGE
                ));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.EMAIL_ALREADY_EXISTS_MESSAGE
                ));
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.ROLE_NOT_FOUND_MESSAGE
                ));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.USER_NOT_FOUND_MESSAGE
                ));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.NO_DATA_FOUND_MESSAGE
                ));
    }
}
