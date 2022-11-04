package com.ca1files;

/* implements rotatable interface */

import java.awt.*;

public class Quadrilateral extends Shape {

    private Point[] points;

    public Quadrilateral(Color color, boolean filled, int xCenter, int yCenter) {
        super(color, filled, xCenter, yCenter);
    }

//    public Quadrilateral(Point centerPoint, Point[] points) {}
//
//    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point
//            p3, Point p4) {};
//
//    public Quadrilateral(Rectangle rectangle) {}

    @Override
    public void drawShape(Graphics g) {
        /* You should use the Graphics object’s drawPolygon() and fillPolygon() methods to render the quad. */

    }

    /* Override ToString for Debugging purposes (console)- 1/11/22 */
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }


}
