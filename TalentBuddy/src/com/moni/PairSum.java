package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class PairSum {

    public static boolean twoNumbersSum(Integer[] array, Integer sum) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] + array[j] == sum){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Integer[] array = {2, 2, 20};
        Integer sum = 5;
        System.out.println(twoNumbersSum(array, sum));
    }
}
