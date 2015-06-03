package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class SortingStudents {

    public static void bubbleSort(Integer[] numbers){
        Integer temp;
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        Integer[] arr = {1, 9, 4, 5, 7};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
