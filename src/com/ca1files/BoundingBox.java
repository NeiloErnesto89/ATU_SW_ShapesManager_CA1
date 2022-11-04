package com.ca1files;

import java.awt.*;

/* Does BB extend shape or is technically a separate entity? */
public class BoundingBox  {

    /* We use BB to determine via mouse clicks if we have clicked on
    * a shape or not */

    /* 49m30 - subsumed */
    private Point bottomLeft;
    private Point topRight;

    /* Main Constructor without extends via shape */

    public BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    //    public BoundingBox(Point bottomLeft, Point topRight) {
//        super(color, filled, xCenter, yCenter);
//        this.bottomLeft = bottomLeft;
//        this.topRight = topRight;
//    }

    /* BB is a square around shape*/




    /* getters & setters */
    public Point getBottomLeft() {
//        System.out.println("here we print the class to see what's in the point: " + bottomLeft);
        return bottomLeft;
    }


    public Point getTopRight () { return topRight; }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

//    @Override
//    public void drawShape(Graphics g) {
//
//    }

    public void getBoundingBox() {}


    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                '}';
    }
}
