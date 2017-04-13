package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("I am a lonely object :(");
    }
}
