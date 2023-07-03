package com.example.practice.configuration;

import com.example.practice.exceptions.RoleNotFoundException;
import com.example.practice.exceptions.UserNotFoundException;
import com.example.practice.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

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
}
