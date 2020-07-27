package com.microservices.unittest.buisness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ListMockTest {

    List<String> mockList = Mockito.mock(List.class);

    @Test
    public void size_basic(){
        Mockito.when(mockList.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5,mockList.size());
        Assertions.assertEquals(10,mockList.size());
    }

    @Test
    public void withParam_basic(){
        Mockito.when(mockList.get(0)).thenReturn("test");
        Assertions.assertEquals("test",mockList.get(0));
        Assertions.assertEquals(null,mockList.get(1));
    }


    @Test
    public void returnWithGenericParameter(){
        Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("test");
        Assertions.assertEquals("test",mockList.get(0));
        Assertions.assertEquals("test",mockList.get(1));
    }

    @Test
    public void verificationBasics(){
        String value = mockList.get(0);
        String value1 = mockList.get(1);

//        By Default it will only check for once
//        Mockito.verify(mockList).get(Mockito.anyInt());
        Mockito.verify(mockList,Mockito.times(2)).get(Mockito.anyInt());
        Mockito.verify(mockList,Mockito.atLeast(1)).get(Mockito.anyInt());
    }

    @Test
    public void argumentCapturing(){
        mockList.add("something");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mockList).add(captor.capture());

        Assertions.assertEquals("something",captor.getValue());
    }

    @Test
    public void mocking(){
        ArrayList mockArrayList = Mockito.mock(ArrayList.class);
        System.out.println(mockArrayList.size());
        mockArrayList.add("test1");
        mockArrayList.add("test2");
        System.out.println(mockArrayList.size());
        Mockito.when(mockArrayList.size()).thenReturn(5);
        System.out.println(mockArrayList.size());
    }

    @Test
    public void spying(){
        ArrayList spyArrayList = Mockito.spy(ArrayList.class);
        System.out.println(spyArrayList.size()); //O/p - 0
        spyArrayList.add("test1");
        spyArrayList.add("test2");
        System.out.println(spyArrayList.size()); //O/p - 2
        Mockito.when(spyArrayList.size()).thenReturn(5); // After this it will lost behaviour
        System.out.println(spyArrayList.size()); //O/p - 5
        spyArrayList.add("test3");
        System.out.println(spyArrayList.size()); //O/p - 5
    }
}
