package com.ca1files;

/* implements rotatable interface */

import java.awt.*;

/* inherits from Shape so has a Center point
* we will use it for rotation, so Quad class
* also implements Rotatble Interface */
public class Quadrilateral extends Shape implements Rotatable {

    private Point[] points;

    public Quadrilateral(Color color, boolean filled, int xCenter, int yCenter) {
        super(color, filled, xCenter, yCenter);
    }

    /*looping over center points to devrive BB points
    * (x1, y2) = smallest x & largest y
    * (x2,y2) = largest x & largest y*/

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


    @Override
    public void rotateNinetyDegrees(int angleDegrees) {
        /* rotating quad obj upon click */
    }
}
