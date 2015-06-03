package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class PairProduct {

    public static int max_product(Integer[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] * array[j] > max && array[i] * array[j] % 3 == 0){
                    max = array[i] * array[j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        Integer[] array = {1,2,8,4,3,7,5};
        System.out.println(max_product(array));
    }
}
