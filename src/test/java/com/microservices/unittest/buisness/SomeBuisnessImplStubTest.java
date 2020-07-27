package com.microservices.unittest.buisness;

import com.microservices.unittest.data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeDataServiceImpl implements SomeDataService{

    @Override
    public int[] retriveAllData() {
        return new int[]{1,2,3};
    }
}

public class SomeBuisnessImplStubTest {

    @Test
    public void calculateSumUsingDataServiceBasic(){
        SomeBuisnessImpl someBuisness = new SomeBuisnessImpl();
        someBuisness.setSomeDataService(new SomeDataServiceImpl());
        int actualResult = someBuisness.calculateSumUsingDataService();
        int expectedResult =6;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    /*@Test
    public void calculateSumBasic_Empty(){
        SomeBuisnessImpl someBuisness = new SomeBuisnessImpl();
        int actualResult = someBuisness.calculateSum(new int[]{});
        int expectedResult =0;
        Assertions.assertEquals(expectedResult,actualResult);
    }*/

}
