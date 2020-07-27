package com.microservices.unittest.buisness;

import com.microservices.unittest.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class SomeBuisnessImplMockAnnotaionTest {

    @InjectMocks // TO create the object and inject mock object into it
    SomeBuisnessImpl someBuisness;

    @Mock
    SomeDataService dataService ;


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
