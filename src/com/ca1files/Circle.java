package com.ca1files;


import java.awt.*;

/* inherits from Shape */
public class Circle extends Shape{

    private int radius;

    public Circle(Color color, boolean filled, int xCenter, int yCenter, int radius) {
        super(color, filled, xCenter, yCenter);
        this.radius = radius;
        /* BB test */
        setupBoundingBox(); // calls BB method below and displays if True

        /* use the radius to calculate the BB -> BB vid1 @ 3.53
        * eg. center = (5,8) .. x-4 and y+4  for bottomLeft == (1,12)
        * therefore xy = 5, 8 .. x+4 & y-4 for TOp Right == (9,4) */
//        this.BoundingBox = new BoundingBox(new Point((xCenter- this.radius),
//                            (yCenter+this.radius),
//                            (xCenter+this.radius),
//                            yCenter-this.radius));
        /* here we create var of BB */
//        this.boundingBox = new BoundingBox(
//                new Point(
//                                xCenter - (radius/2),
//                                yCenter + (radius/2)), //(x1, y1)
//                    new Point(
//                                xCenter + (radius/2),
//                                yCenter + (radius/2)) // (x2, y2)
//                            );
    }


    /* had to remove extends Shape class as was incorrect
    * how to check viability of BB if correct */
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

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void drawShape(Graphics g) {
        System.out.println("Drawing a circle");
        g.setColor(color); // color passed int
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        /* calculating where to place circle on frame */
        int pointX = xCenter - (radius / 2);
        int pointY = yCenter - (radius / 2);
        /* if true - can untoggle */

        if (filled) {
            g.fillOval(pointX, pointY, radius, radius);
        }
        else {
            g.drawOval(pointX, pointY, radius, radius);
        }
    }

    /* Override ToString for Debugging purposes (console) - 01/11/22 */
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
