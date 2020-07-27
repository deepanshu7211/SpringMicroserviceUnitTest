package com.microservices.unittest.buisness;

import com.microservices.unittest.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SomeBuisnessImplMockTest {

    SomeBuisnessImpl someBuisness = new SomeBuisnessImpl();
    SomeDataService dataService = Mockito.mock(SomeDataService.class);

    @BeforeEach
    public void before(){
        someBuisness.setSomeDataService(dataService);
    }

    @Test
    public void calculateSumUsingDataServiceUsingMockBasic(){

        //dataService retriveAllData new int[]{1,2,3}
        Mockito.when(dataService.retriveAllData()).thenReturn(new int[]{1,2,3});
        Assertions.assertEquals(6,someBuisness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataServiceUsingMock_empty(){
        //dataService retriveAllData new int[]{1,2,3}
        Mockito.when(dataService.retriveAllData()).thenReturn(new int[]{});
        Assertions.assertEquals(0,someBuisness.calculateSumUsingDataService());
    }


}
