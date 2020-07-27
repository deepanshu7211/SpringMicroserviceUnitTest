package com.microservices.unittest.buisness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeBuisnessImplTest {

    @Test
    public void calculateSumBasic(){
        SomeBuisnessImpl someBuisness = new SomeBuisnessImpl();
        int actualResult = someBuisness.calculateSum(new int[]{1,2,3});
        int expectedResult =6;
        Assertions.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSumBasic_Empty(){
        SomeBuisnessImpl someBuisness = new SomeBuisnessImpl();
        int actualResult = someBuisness.calculateSum(new int[]{});
        int expectedResult =0;
        Assertions.assertEquals(expectedResult,actualResult);
    }
}
