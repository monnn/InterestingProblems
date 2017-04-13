package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class MissingNumber {

    public static Integer findMissingNumber(Integer[] array){
        Integer sumAll = 0;
        Integer sumArray = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            sumAll += i;
        }
        for (int i = 0; i < array.length; i++) {
            sumArray += array[i];
        }
        Integer missingNumber = sumAll - sumArray;
        return missingNumber;
    }
    
    public static void main(String[] args){
        Integer[] array = {1,2,8,4,3,7,5};
        System.out.println(findMissingNumber(array));
    }
}
