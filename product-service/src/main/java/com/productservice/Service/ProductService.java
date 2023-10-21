package com.productservice.Service;

import com.productservice.Request.ProductRequest;
import com.productservice.Response.ProductResponse;
import com.productservice.Respository.ProductRepositroy;
import com.productservice.customExcpetion.productnotfoundexpection;
import com.productservice.module.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


   private final ProductRepositroy productRepositroy;



   public void saveProduct(ProductRequest productRequest){

       Product product = Product.builder()
               .product(productRequest.getProduct())
               .discretion(productRequest.getDiscretion())
               .price(productRequest.getPrice())
               .build();

       productRepositroy.save(product);

   }


   public List<ProductResponse> getAllProduct(String prod){

       if(prod != null){

           List<Product> responses =  productRepositroy.findAllByproduct(prod);
           return   responses.stream().map(product -> mapToProductResposne(product)).toList();

             }
       else {


           List<Product> products = productRepositroy.findAll();

           return products.stream().map(product -> mapToProductResposne(product)).toList();
       }
   }

    public ProductResponse mapToProductResposne(Product product) {


      return    ProductResponse.builder()
               .product(product.getProduct())
               .discretion(product.getDiscretion())
               .price(product.getPrice()).build();


    }


    public String checkproductexsting(String product) {

       Product selectedprod =  productRepositroy.findByproduct(product);

        if(selectedprod == null){
            throw  new productnotfoundexpection("Given product unable to deleted because  not found");
        }
        else{
            productRepositroy.delete(selectedprod);
            return "The Given product successfully deleted!!!";
        }


    }
}
