package com.productservice.Respository;

import com.productservice.Response.ProductResponse;
import com.productservice.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositroy extends JpaRepository<Product, Long> {
    List<Product> findAllByproduct(String prod);

    Product findByproduct(String product);
}
