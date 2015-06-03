package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class FindingString {

    public static String findString(String str1, String str2) {
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            int j;
            for (j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) != str1.charAt(i + j)){
                    break;
                }
            } if (j == str2.length()){
                return "Substring found! Starting at position " + i;
            }
        }
        return "Substring not found";
    }

    public static void main(String[] args){
        String str1 = "asdfghjnbv";
        String str2 = "ghj";
        System.out.println(findString(str1, str2));
    }
}
