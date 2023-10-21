package com.productservice;


import com.productservice.Request.ProductRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class WebLayerTest extends BaseClass{


    @Autowired
    private MockMvc mockMvc;



    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void saveapitest() throws Exception {

      ProductRequest productRequest =   getProductResquest();
              String test =   objectMapper.writeValueAsString(productRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(test)).andExpect(status().isCreated());

    }

    private ProductRequest getProductResquest() {

        return ProductRequest.builder()
                .product("NOkia")
                .discretion("desc")
                .price("15000")
                .build();

    }


}
