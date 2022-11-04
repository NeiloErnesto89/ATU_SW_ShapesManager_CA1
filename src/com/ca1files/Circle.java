package com.ca1files;


import java.awt.*;

/* inherits from Shape */
public class Circle extends Shape{

    private int radius;

    public Circle(Color color, boolean filled, int xCenter, int yCenter, int radius) {
        super(color, filled, xCenter, yCenter);
        this.radius = radius;

        /* use the radius to calculate the BB -> BB vid1 @ 3.53
        * eg. center = (5,8) .. x-4 and y+4  for bottomLeft == (1,12)
        * therefore xy = 5, 8 .. x+4 & y-4 for TOp Right == (9,4) */
//        this.BoundingBox = new BoundingBox(new Point((xCenter- this.radius),
//                            (yCenter+this.radius),
//                            (xCenter+this.radius),
//                            yCenter-this.radius));
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
