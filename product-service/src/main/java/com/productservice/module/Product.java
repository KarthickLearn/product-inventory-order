package com.productservice.module;


import com.productservice.customExcpetion.productnotfoundexpection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name =  "product")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;
    private String product;
    private String discretion;
    private String price;




}
