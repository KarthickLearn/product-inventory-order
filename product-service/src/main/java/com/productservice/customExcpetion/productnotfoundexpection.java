package com.productservice.customExcpetion;

import com.productservice.module.Product;

public class productnotfoundexpection extends RuntimeException {

    private String message;

    public productnotfoundexpection(String message){
        super(message);
        this.message = message;
    }

}
