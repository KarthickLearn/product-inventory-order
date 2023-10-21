package com.productservice.Controller;

import com.productservice.Request.ProductRequest;
import com.productservice.Response.ProductResponse;
import com.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class HomeContorller {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createdProduct(@RequestBody ProductRequest productRequest){
        productService.saveProduct(productRequest);

        return "Product successfully Created!!!!";
    }
    @GetMapping
     @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getALlProduct(@RequestParam (value = "product", required = false) String prod){
       return productService.getAllProduct(prod);
    }


    @DeleteMapping
    public String deleteprocduct(@RequestParam(value = "product", required = true ) String product){

        return productService.checkproductexsting(product);

    }





}
