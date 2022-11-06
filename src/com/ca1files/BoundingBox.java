package com.ca1files;

import java.awt.*;

/* Does BB extend shape or is technically a separate entity? */
public class BoundingBox  {

    /* We use BB to determine via mouse clicks if we have clicked on
    * a shape or not */

    /* 49m30 - subsumed */
    private Point bottomLeft; // 06/11/22 - revert to private access mods as BB methods only using
    private Point topRight;

    /* Main Constructor without extends via shape */
    /* BB is a square around shape*/

    public BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public int BBAddTenToBottomLeftX() {
        this.bottomLeft = bottomLeft;
        return this.bottomLeft.getXPlusTen();
    }

    public int BBAddTenToTopRightX() {
        this.topRight = topRight;

        return this.topRight.getXPlusTen();
    }

//    public Point quadBoundingBox(Point[] points) {
//        return this.topRight = points[1] this.bottomLeft = points[3];
//    }

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

    /* getters & setters */
    public Point getBottomLeft() {
//        System.out.println("here we print the class to see what's in the point: " + bottomLeft);
        return bottomLeft;
    }

    public Point getTopRight () { return topRight; }
//
//    public void setBottomLeft(Point bottomLeft) {
//        this.bottomLeft = bottomLeft;
//    }
//
//    public void setTopRight(Point topRight) {
//        this.topRight = topRight;
//    }
//
//    public void getBoundingBox() {}


    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                '}';
    }
}
