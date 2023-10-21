package com.inverntoryservice.InventroyService;

import com.inverntoryservice.InventroyService.inventory.Inventory;
import com.inverntoryservice.InventroyService.inventory.InventroyRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@RequiredArgsConstructor

class InventroyServiceApplicationTests {

	@Autowired
 	private final MockMvc mockMvc;




	@Test
	void saveInventory() throws Exception {


		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8083/api/inventroy?orderItem=Honot"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
