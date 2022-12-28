package org.example;

public class Tester {
    private MyMathController mathController;

    public Tester(MyMathController mathController) {
        this.mathController = mathController;
    }

    public static void main(String[] args) {
        Tester tester=new Tester(new MyMathController(new MyMathService()));
        System.out.println(tester.mathController.add(4,5));

    }
}
