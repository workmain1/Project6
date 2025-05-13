package com.example.project6;

public class Part1 {


    public int sum1toN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum1toN(n - 1);
        }
    }


    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }


    public static void main(String[] args) {
        Part1 rs = new Part1();


        int sumResult = rs.sum1toN(5);
        System.out.println("sum1toN(5) = " + sumResult);

        // Test power
        double powerResult = rs.power(2, 3);
        System.out.println("power(2, 3) = " + powerResult);
    }
}

