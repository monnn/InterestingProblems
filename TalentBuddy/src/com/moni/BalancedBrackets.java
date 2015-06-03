package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BalancedBrackets {

    public static boolean balancedBrackets(String s) {
        int brackets = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                brackets++;
            } else if (s.charAt(i) == ')') {
                brackets--;
                if (brackets < 0){
                    return false;
                }
            }
        }
        if (brackets == 0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        String s = ")((())";
        System.out.println(balancedBrackets(s));
    }
}
