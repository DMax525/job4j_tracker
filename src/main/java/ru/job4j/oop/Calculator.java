package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int a) {
        return a - x;
    }

    public static int sum(int b) {
        return x + b;
    }

    public int divide(int c) {
        return c / x;
    }

    public int multiply(int d) {
        return x * d;
    }

    public int sumAllOperation(int e) {
        return sum(e) + multiply(e) + minus(e) + divide(e);
    }

    public static void main(String[] args) {
        int sum = sum(10);
        System.out.println("Sum: " + sum);

        int minus = minus(10);
        System.out.println("Minus: " + minus);

        Calculator calculator = new Calculator();
        int mult = calculator.multiply(10);
        System.out.println("Multiply: " + mult);

        int div = calculator.divide(10);
        System.out.println("Divide: " + div);

        int sumAll = calculator.sumAllOperation(10);
        System.out.println("SumAll: " + sumAll);
    }
}
