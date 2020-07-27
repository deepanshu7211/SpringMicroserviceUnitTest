package com.microservices.unittest.buisness;

import com.microservices.unittest.contoller.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    public Item retrieveAllItems() {
        return new Item(1,"Ball",10,100);
    }
}
