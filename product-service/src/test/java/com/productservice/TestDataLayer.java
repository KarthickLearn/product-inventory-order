package com.productservice;


import com.productservice.Respository.ProductRepositroy;
import com.productservice.module.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestDataLayer {

    @Autowired
    ProductRepositroy productRepositroy;

    @Test
    public  void savedb(){


        Product product = Product.builder()
                .discretion("des")
                .price("1850")
                .product("Test")
                .build();

        Product savedproduct =  productRepositroy.save(product);

        Assertions.assertThat(savedproduct).usingRecursiveComparison().ignoringFields("id")
                .isEqualTo(product);

    }

}
