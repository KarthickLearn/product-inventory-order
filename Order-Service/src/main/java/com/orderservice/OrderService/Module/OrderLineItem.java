package com.orderservice.OrderService.Module;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String orderItem;
    private  Integer quantity;
    private BigDecimal price;


}
