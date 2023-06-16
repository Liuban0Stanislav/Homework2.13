package com.example.homework2_13.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class WrongDeptException extends RuntimeException{
    public WrongDeptException() {
    }

    public WrongDeptException(String message) {
        super(message);
    }
}
