package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class MyMathControllerTest {

    @InjectMocks
    MyMathController mathController;

    @Mock
    MyMathService mathService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void add(){
        when (mathService.add(3,4)).thenReturn(7);
        Assertions.assertEquals(7,mathController.add(3,4));
        ArgumentCaptor<Integer> argumentCaptor=ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> argumentCaptor2=ArgumentCaptor.forClass(Integer.class);
//        System.out.println(argumentCaptor.capture());
        verify(mathService).add((Integer) argumentCaptor.capture(),(Integer) argumentCaptor2.capture());
        System.out.println(argumentCaptor.getValue()+argumentCaptor2.getValue());
    }
    @Test
    public void printAdd(){
        when (mathService.add(3,4)).thenAnswer(invocationOnMock -> {
            int a=invocationOnMock.getArgument(0);
            int b=invocationOnMock.getArgument(1);
            System.out.println("a="+a + "b="+b);
            return a+b;
        });
        mathController.printSum(3,4);
        verify(mathService).add(3,4);
  }
}
