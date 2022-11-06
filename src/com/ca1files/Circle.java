package com.ca1files;

import java.awt.*;

/* Circle class inherits from the abstract Shape class  */
public class Circle extends Shape{

    /* radius is needed to derive co-ords for the Circle & it's bounding box
    * for example, use the radius to calculate the BB (below)
     * eg. center = (5,8) .. x-4 and y+4  for bottomLeft == (1,12)
     * therefore xy = 5, 8 .. x+4 & y-4 for Top Right == (9,4) */
    private int radius;

    /* the Circles constructor, with the args that are needed to great a Circle object */

    public Circle(Color color, boolean filled, int xCenter, int yCenter, int radius) {
        super(color, filled, xCenter, yCenter);
        this.radius = radius;
        setupBoundingBox(); // calls BB method below

    }

    /* method to create a bounding box around the Circle derived using
     * the params passed in and some simple calculations (co-rd geometry) */
    public void setupBoundingBox()
    {
        this.boundingBox = new BoundingBox(
                    new Point(
                                (xCenter - (radius/2)),
                                (yCenter + (radius/2))), //bottom left - (x1, y1)
                      new Point(
                              (xCenter + (radius/2)),
                              (yCenter - (radius/2))) // top right - (x2, y2)
                    );

//        boundingBox = new BoundingBox(new Point(100, 100), new Point(60, 80));
    }

    /* Bounding Box getter method */
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    /* This method is overridden via the abstract Shape class & it checks if
    * a circle is filled or not (bool) and proceeds to display on the gui */
    @Override
    public void drawShape(Graphics g) {
//        System.out.println("Drawing a circle");
        g.setColor(color); // color passed in
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        /* calculating where to place circle on frame */
        int pointX = xCenter - (radius / 2);
        int pointY = yCenter - (radius / 2);

        /* if true - can un-toggle with rightClick invocation */
        if (filled) {
            g.fillOval(pointX, pointY, radius, radius);
        }
        else {
            g.drawOval(pointX, pointY, radius, radius);
        }
    }

    /* Override ToString for Debugging purposes (console) */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }
}
