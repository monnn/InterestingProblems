package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class OccurencesCounter {

    public static int countOccurences(Integer[] array, Integer k) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (k == array[i]){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Integer[] v = {1, 1, 2, 2, 2, 2, 2, 7, 7, 7, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 22, 22, 22, 25, 25, 27, 27, 27, 27, 27, 27, 27, 27, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 47, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 61, 61, 61, 61, 61, 61, 67, 67, 69, 69, 69, 69, 69, 69, 69, 69, 69, 69, 69, 69, 69, 82, 82, 84, 84, 86, 86, 86, 86, 86, 86, 86, 93, 93, 93, 93, 93, 93, 93, 100, 100, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 119, 119, 121};
        int k = 102;
        System.out.println(countOccurences(v, k));
    }
}
