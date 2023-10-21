package com.inverntoryservice.InventroyService;

import com.inverntoryservice.InventroyService.inventory.Inventory;
import com.inverntoryservice.InventroyService.inventory.InventroyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class InventroyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventroyServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner savetodb(InventroyRepository inventroyRepository){


		return args -> {


		Inventory inventory = new Inventory();
		inventory.setItem("Samsang");
		inventory.setQuantity(20);

		Inventory inventory1 = new Inventory();
		inventory1.setItem("Honot");
		inventory1.setQuantity(0);




		inventroyRepository.save(inventory1);
		inventroyRepository.save(inventory);
		};
	}



}
