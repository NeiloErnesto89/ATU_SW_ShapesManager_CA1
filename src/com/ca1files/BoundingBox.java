package com.ca1files;

import java.awt.*;

/* Does BB extend shape or is technically a separate entity? */
public class BoundingBox extends Shape {

    /* We use BB to determine via mouse clicks if we have clicked on
    * a shape or not */

    /* 49m30 - subsumed */
    private Point bottomLeft;
    private Point topRight;

    /* BB is a square around shape*/
    public BoundingBox(Color color, boolean filled, int xCenter, int yCenter) {
        super(color, filled, xCenter, yCenter);
    }



    /* Derived BB from Points x, y*/

    public BoundingBox(Color color, boolean filled, int xCenter, int yCenter, Point bottomLeft, Point topRight) {
        super(color, filled, xCenter, yCenter);
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft () { return bottomLeft; }

    public Point getTopRight () { return topRight; }
    @Override
    public void drawShape(Graphics g) {

    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "bottomLeft=" + bottomLeft +
                ", topRight=" + topRight +
                '}';
    }
}
