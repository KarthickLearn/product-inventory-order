package com.orderservice.OrderService.dto;

import lombok.*;

import java.math.BigDecimal;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItemDto {
    private Long  id;
    private String orderItem;
    private  Integer quantity;
    private BigDecimal price;


}
