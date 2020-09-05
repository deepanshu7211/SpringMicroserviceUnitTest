package com.microservices.unittest.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

// It will take the port from the available port from the machine. As our application will be running on the some port
//That port will not be used
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response  = restTemplate.getForObject("/allItems",String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]",response,false);
    }
}
