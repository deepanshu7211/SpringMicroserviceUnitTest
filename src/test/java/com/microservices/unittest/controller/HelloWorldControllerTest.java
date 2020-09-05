package com.microservices.unittest.controller;

import com.microservices.unittest.contoller.HelloWorldController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWorld_basic() throws Exception {
        //call /hello-world Get and application/Json
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                            .andReturn();

//        Verification of the Response
        Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testPostHelloWorld_basic() throws Exception {
        //call /hello-world Get and application/Json
        RequestBuilder request = MockMvcRequestBuilders.post("/hello-world")
                .content("hello-world from post")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("hello-world from post"))
                .andReturn();

//        Verification of the Response
//        Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }
}
