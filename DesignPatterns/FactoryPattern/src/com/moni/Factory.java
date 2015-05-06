package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Factory {

    public Shape getShape(String shape){
        if (shape.equalsIgnoreCase("circle")){
            return new Circle();
        }
        if (shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
