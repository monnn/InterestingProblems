package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRed(decoratedShape);
    }

    private void setRed(Shape decoratedShape){
        System.out.println("It's color is red");
    }
}
