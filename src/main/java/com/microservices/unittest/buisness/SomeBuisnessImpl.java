package com.microservices.unittest.buisness;

import com.microservices.unittest.data.SomeDataService;

import java.util.Arrays;

public class SomeBuisnessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int [] data){
        int sum = Arrays.stream(data).sum();
        return sum;
    }

    public int calculateSumUsingDataService(){
        int data[] = someDataService.retriveAllData();
        int sum = Arrays.stream(data).sum();
        return sum;
    }
}
