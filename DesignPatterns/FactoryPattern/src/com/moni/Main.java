package com.moni;

public class Main {

    public static void main(String[] args) {
	Factory shF = new Factory();
        Shape shape1 = shF.getShape("circle");
        shape1.draw();
        Shape shape2 = shF.getShape("rectangle");
        shape2.draw();
    }
}
