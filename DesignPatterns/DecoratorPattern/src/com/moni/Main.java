package com.moni;

public class Main {

    public static void main(String[] args) {
	    Shape circle = new ShapeDecorator(new Circle());
        Shape redCircle = new RedShapeDecorator(new Circle());
        circle.draw();
        redCircle.draw();
    }
}
