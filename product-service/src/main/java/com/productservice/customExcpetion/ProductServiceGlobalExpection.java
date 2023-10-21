package com.productservice.customExcpetion;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceGlobalExpection{

    @ExceptionHandler
    public ResponseEntity globalexpection(Exception e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went to Wrong!! Try again after sometime");
    }

}
