package com.inverntoryservice.InventroyService.controller;

import com.inverntoryservice.InventroyService.inventory.InventoryDTO;
import com.inverntoryservice.InventroyService.inventory.InventroyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventroy")
@RequiredArgsConstructor
public class InventroyControler {

    private  final InventroyService inventroyService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDTO> inventroyStatus(@RequestParam ( value = "orderItem") List<String> item){

        return inventroyService.getInventorystatus(item);
    }


}
