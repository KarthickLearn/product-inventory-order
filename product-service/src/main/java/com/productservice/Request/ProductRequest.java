package com.productservice.Request;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private long id;
    private String product;
    private String discretion;
    private String price;


}
