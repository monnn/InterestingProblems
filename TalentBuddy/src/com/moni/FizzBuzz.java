package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class FizzBuzz {

    public static void fizzbuzz(Integer n) {
        for (int i = 1; i < n + 1; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("com.moni.FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){
        fizzbuzz(100);
    }
}
