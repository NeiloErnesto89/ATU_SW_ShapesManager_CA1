package com.ca1files;

import java.awt.*;

/* Bounding Box class will create a box that surrounds the shapes.
* The boundaries will be dotted and  used to detect mouse clicks within
* a shape's bounding box and therefore, invoke a method() if needed */

public class BoundingBox  {

    /* BB is always a square, so we subsume that we just need the 2 Points (x,y)
    * to derive the bounding box co-ords and therefore, to derive its size and position */
    private Point bottomLeft;
    private Point topRight;

    /* Main Constructor */
    public BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    /* this method is used to return the bottom left co-ords +=10 (via Point class) - upon a left click on a Rect */
    public int BBAddTenToBottomLeftX() {
        this.bottomLeft = bottomLeft;
        return this.bottomLeft.getXPlusTen();
    }

    /* this method is used to return the top right co-ords +=10 (via Point class) - upon a left click on a Rect */
    public int BBAddTenToTopRightX() {
        this.topRight = topRight;

        return this.topRight.getXPlusTen();
    }

    /* unused and commented out code from earlier test */
//    public int BBAddToTenBotLeft() {
//        this.bottomLeft = bottomLeft;
//
//        return this.bottomLeft.x += 10;
//    }
//
//    public int BBAddTenTopRightX() {
//        this.topRight = topRight;
//
//        return this.topRight.x += 10;
//    }

    /* getters & setters for bottom left and top right co-rds */
    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight () {
        return topRight;
    }

    /* unused and commented out code for set points*/
//    public void setBottomLeft(Point bottomLeft) {
//        this.bottomLeft = bottomLeft;
//    }
//
//    public void setTopRight(Point topRight) {
//        this.topRight = topRight;
//    }



    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                '}';
    }
}
