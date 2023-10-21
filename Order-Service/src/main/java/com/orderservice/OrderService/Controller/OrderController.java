package com.orderservice.OrderService.Controller;

import com.orderservice.OrderService.dto.OrderRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor

public class OrderController {


    @Autowired
    private final OrderService orderService;

    @PostMapping

   @CircuitBreaker(name = "inventory", fallbackMethod = "noResposneRecevideFromInvoiceservice")
    public ResponseEntity saveOrderToDB(@RequestBody OrderRequest orderRequest) {

        orderService.SaveproductotDB(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order Successfully created!!!");
    }



    public ResponseEntity noResposneRecevideFromInvoiceservice(OrderRequest orderRequest, RuntimeException runtimeException){

       return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("Oops! Something went to worng, please try againg later!!");

    }
}