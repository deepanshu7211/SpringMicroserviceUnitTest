package com.microservices.unittest.data;

import com.microservices.unittest.contoller.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void findAllTest(){
//        This will check in the in -memory DB and execute data.sql file
//        For Live Env. we can copy the data.sql file to the test Package.
        List<Item> itemList = repository.findAll();
        Assertions.assertEquals(3,itemList.size());
    }
}
