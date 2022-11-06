package com.ca1files;

import java.awt.*;

/* Square class inherits from Rectangle class */
public class Square extends Rectangle {

    /* Constructor with inherits from (superclass) Rectangle
    * we adapt slightly to ensure height and width are the same
    * via the 'sides' var (square must have equal sides)*/
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
