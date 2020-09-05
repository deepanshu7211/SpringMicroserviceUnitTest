package com.microservices.unittest.contoller;

import com.microservices.unittest.buisness.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {


    @Autowired
    private ItemsService itemsService;

    @GetMapping("/items")
    public Item getItems(){
        return new Item(1,"Ball",10,100);
    }

    @GetMapping("/items-service")
    public Item getItemsFromService(){
        return itemsService.retrieveAllItems();
    }

    @GetMapping("/allItems")
    public List<Item> getAllItems(){
        return itemsService.getAllItems();
    }
}
