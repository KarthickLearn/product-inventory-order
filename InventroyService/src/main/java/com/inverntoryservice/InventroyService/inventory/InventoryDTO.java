package com.inverntoryservice.InventroyService.inventory;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventoryDTO {

    private String item;
    private Boolean result;

}
