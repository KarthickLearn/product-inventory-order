package com.productservice;

import com.productservice.Request.ProductRequest;
import com.productservice.Respository.ProductRepositroy;
import com.productservice.Service.ProductService;
import com.productservice.module.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRespositoryTest {
    @Autowired
    ProductRepositroy productRepositroy;

    @Test
    @DisplayName("Save the product to product database")
    public void savedb(){

        ProductRequest productRequest = ProductRequest.builder()
                .product("Nokia")
                .discretion("desc")
                .price("15000")
                .build();


        productRepositroy.save(Product.builder()
                        .product(productRequest.getProduct())
                        .discretion(productRequest.getDiscretion())
                                .price(productRequest.getPrice())
                .build());

        Product  product =  productRepositroy.findByproduct(productRequest.getProduct());

        Assertions.assertThat(productRequest).usingRecursiveComparison().ignoringFields("id").isEqualTo(product);

    }









}
