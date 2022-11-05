package com.ca1files;

import java.awt.*;

/* inherits from Shape */
public class Rectangle extends Shape implements Moveable {

    /* private vars */
    private int width;
    private int height;

    public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super(color, filled, xCenter, yCenter);
        this.width = width;
        this.height = height;

        setupBoundingBox();
//        this.boundingBox = new BoundingBox(new Point(xCenter-(width/2),yCenter+(height/2)),new Point(xCenter+(width/2),yCenter-(height/2)));
//        this.boundingBox = new BoundingBox((new Point((xCenter-(width/2)),(yCenter+(height/2)))),new Point((xCenter+(width/2)),(yCenter-(height/2))));

    }

    private void setupBoundingBox() {
        this.boundingBox = new BoundingBox(
                        (new Point
                                            ((xCenter-(width/2)), (yCenter+(height/2)))),
                        new Point
                                            ((xCenter+(width/2)),(yCenter-(height/2))));
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    //    public Rectangle(int width, int height) {
//        super();
//        this.width = width;
//        this.height = height;
//    }

    @Override
    public void drawShape(Graphics g) {
        /* vars passed in as args in */
        System.out.println(this.toString()); // the 'shapes' object - class 3-  1hr04m (just console)
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(1));
        /* 02/11/22 -> offset center x & y to get actual shape */
        int pointX = (xCenter - (width/2)); // so if X = 200 and width = 80- > 200 - (80/2) = 160 (offsetting center)
        int pointY = (yCenter - (height/2)); // height is on Y axis, to find center point
        System.out.println("this is point x (should be 160): " + pointX + ". This should be point y (120): " + pointY);

        /* check if filled (via mouse click toggle) */
        if (filled) {
            g.fillRect(pointX, pointY, width, height);
        }

        else {
            g.drawRect(pointX, pointY, width, height);
            }
        }


    @Override
    public boolean rightClick() {
        /* calls the move10units method below */
        moveTenUnits();
        return true;

    }

    public void moveTenUnits() {
        /* shift 3 points x10 to the right -> */
        Point bottomLeftPoint = boundingBox.getBottomLeft();
        int bottomLeftX = bottomLeftPoint.getX();

        bottomLeftX += 10; // bottom left x 10

        Point topRightPoint = boundingBox.getTopRight();
        int topRightY = topRightPoint.getY();

        topRightY += 10;

        xCenter += 10;

    }


    /* Override ToString for Debugging purposes (console) - 01/11/22 */
    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}' + super.toString();
    }
}
