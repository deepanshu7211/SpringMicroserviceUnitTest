package com.microservices.unittest.buisness;

import com.microservices.unittest.contoller.Item;
import com.microservices.unittest.data.ItemRepository;
import com.microservices.unittest.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks // TO create the object and inject mock object into it
    ItemsService itemsService;

    @Mock
    ItemRepository repository ;

    @Test
    public void getAllItemsTest(){

        //dataService retriveAllData new int[]{1,2,3}
        Mockito.when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(1,"Ball",10,10),
                        new Item(2,"bat",20,20)));

        List<Item> items = itemsService.getAllItems();
        Assertions.assertEquals(100,items.get(0).getValue());
        Assertions.assertEquals(400,items.get(1).getValue());

    }
}
