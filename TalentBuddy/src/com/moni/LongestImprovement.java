package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class LongestImprovement {

    public static int longestImprovement(Integer[] grades) {
        int impr = 1;
        int temp = 0;
        for (int i = 1; i < grades.length - 1; i++) {
            while (grades[i - 1] <= grades[i]) {
                impr++;
                if(i >= grades.length - 1) {
                    break;
                }
                i++;
            }
            if (impr > temp) {
                temp = impr;
            }
            impr = 1;
        }
        return temp;
    }

    public static void main(String[] args){
        Integer[] grades = {6, 7, 5, 3, 6, 6, 8, 9, 11, 3, 3, 3};
        System.out.println(longestImprovement(grades));
    }
}
