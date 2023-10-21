package com.productservice;

import com.productservice.Request.ProductRequest;
import com.productservice.Response.ProductResponse;
import com.productservice.Respository.ProductRepositroy;
import com.productservice.Service.ProductService;
import com.productservice.module.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import  org.assertj.core.api.Assertions;

import java.util.List;

@SpringBootTest

public class ProductServiceApplicationTests {
	ProductRepositroy productRepositroy = Mockito.mock(ProductRepositroy.class);
	ProductService productService = new ProductService(productRepositroy);

	@Captor
	ArgumentCaptor<Product> argumentCaptor;

	@Test
	@DisplayName("This will covert product object inoto productresponseobject")
	void checkproductservicemethosd() {

		Product product = Product.builder().id(1).product("HTC").price("10000").discretion("Phone").build();
		ProductResponse productResponse = ProductResponse.builder().product("HTC").price("10000").discretion("Phone").build();
		org.assertj.core.api.Assertions.
        assertThat(productService.mapToProductResposne(product)).isEqualTo(productResponse);


	}


	@Test
	@DisplayName("Save Product to DB")
	public void getproductresponse(){

		ProductRequest productRequest = ProductRequest.builder()
				.product("Nokia")
				.discretion("Desc")
				.price("15000")
				.build();

		Product product = Product.builder()
						.product(productRequest.getProduct())
								.price(productRequest.getPrice())
										.discretion(productRequest.getDiscretion()).build();


		productService.saveProduct(productRequest);

		Mockito.verify(productRepositroy, Mockito.times(1)).save(ArgumentMatchers.any(Product.class));


	}


	@Test
	@DisplayName("Should Return List of Product")
	public void getListofProductResponseTest(){
	productService.getAllProduct("Samsang");
	Mockito.verify(productRepositroy,Mockito.times(1)).findAllByproduct(ArgumentMatchers.any(String.class));

	}






}
