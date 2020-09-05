package com.microservices.unittest.controller;

import com.microservices.unittest.buisness.ItemsService;
import com.microservices.unittest.contoller.HelloWorldController;
import com.microservices.unittest.contoller.Item;
import com.microservices.unittest.contoller.ItemController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsService itemsService;

    @Test
    public void testGetItem_basic() throws Exception {
        //call /hello-world Get and application/Json
        RequestBuilder request = MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                            .andReturn();

//        Verification of the Response
//        Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGetItemFromService_basic() throws Exception {

        Mockito.when(itemsService.retrieveAllItems()).thenReturn(new Item(1,"Ball",10,100));

        //call /hello-world Get and application/Json
        RequestBuilder request = MockMvcRequestBuilders.get("/items-service").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

//        Verification of the Response
//        Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void testgetAllItems_basic() throws Exception {

        Mockito.when(itemsService.getAllItems()).thenReturn(
                Arrays.asList(new Item(1,"Ball",10,100)));

        //call /hello-world Get and application/Json
        RequestBuilder request = MockMvcRequestBuilders.get("/allItems").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}]"))
                .andReturn();

//        Verification of the Response
//        Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }
}
