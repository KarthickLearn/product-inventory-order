package com.inverntoryservice.InventroyService.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventroyService {


    private final InventroyRepository inventroyRepository;


    public List<InventoryDTO> getInventorystatus(List<String> item) {

        List<Inventory> inventories = inventroyRepository.findByItemIn(item);


            List<InventoryDTO> inventoryDTOList = inventories.stream().map(inventory -> {
                return InventoryDTO.builder().item(inventory.getItem())
                        .result(inventory.getQuantity() > 0).build();
            }).toList();
            return inventoryDTOList;

    }
}
