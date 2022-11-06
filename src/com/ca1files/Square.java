package com.ca1files;

import java.awt.*;

public class Square extends Rectangle {

    /* Constructor with inherits from (superclass) Rectangle*/
    /* Constructor with inherits from (superclass) Rectangle*/
    public Square(Color color, boolean filled, int xCenter, int yCenter, int sides) { // formerly int width, int height
        super(color, filled, xCenter, yCenter, sides, sides);
    }

    @Override
    public String toString() {
        return "Square{ " + this.getClass().getSimpleName() +
                " color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                ", boundingBox=" + boundingBox +
                '}';
    }
}
