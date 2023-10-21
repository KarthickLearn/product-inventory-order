package com.orderservice.OrderService.Controller;

import com.orderservice.OrderService.Module.Order;
import com.orderservice.OrderService.Module.OrderLineItem;
import com.orderservice.OrderService.dto.InventoryDTO;
import com.orderservice.OrderService.dto.OrderLineItemDto;
import com.orderservice.OrderService.dto.OrderRequest;
import com.orderservice.OrderService.Respositroy.OrderRepositroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepositroy orderRepositroy;
    private final WebClient.Builder webClient;

    public void SaveproductotDB(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItemDtoList = orderRequest.getOrderLineItemDtoList().stream().map(this::mapToOrderLineItem).toList();
        order.setOrderLineItemlist(orderLineItemDtoList);

        List<String> items = orderLineItemDtoList.stream().map(m->m.getOrderItem()).toList();



        InventoryDTO[]  inventoryDTOS =  webClient.build().get()
                .uri("http://INVENTORY-SERVICE/api/inventroy",
                        UriBuilder -> UriBuilder.queryParam("orderItem", items).build())
                              .retrieve().bodyToMono(InventoryDTO[].class).block();


        boolean result = Arrays.stream(inventoryDTOS).allMatch(m -> m.getResult());

        if(result){
             orderRepositroy.save(order);
         }else {
             throw new IllegalArgumentException("No request order found, plz try again later!!!");
         }


    }

    private OrderLineItem mapToOrderLineItem(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setOrderItem(orderLineItemDto.getOrderItem());
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        return orderLineItem;
    }
}