package org.example;

public class MyMathController {
    private MyMathService mathService;

    public MyMathController(MyMathService mathService) {
        this.mathService = mathService;
    }

    public int add(int a, int b){
        return mathService.add(a,b);
    }

    public void printSum(int a, int b){
        System.out.println(mathService.add(a,b));
    }
}
