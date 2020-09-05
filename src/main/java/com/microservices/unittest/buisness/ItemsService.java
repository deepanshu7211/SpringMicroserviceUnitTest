package com.microservices.unittest.buisness;

import com.microservices.unittest.contoller.Item;
import com.microservices.unittest.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveAllItems() {
        return new Item(1,"Ball",10,100);
    }

    public List<Item> getAllItems(){
        List<Item> itemList = repository.findAll();
        for(Item item : itemList){
            item.setValue(item.getPrice()* item.getQuantity());
        }
        return itemList;
    }
}
