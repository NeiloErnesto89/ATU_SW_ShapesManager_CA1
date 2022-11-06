package com.ca1files;

import java.awt.*;

/* inherits from Shape and implements moveable */
public class Rectangle extends Shape implements Moveable {

    /* private Rect vars */
    protected int width;
    protected int height;

    public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super(color, filled, xCenter, yCenter);
        this.width = width;
        this.height = height;
        /* Invokes setting up BB */
        setupBoundingBox();

        /* setting up BB via constructor but Ichanged to call a method */
//        this.boundingBox = new BoundingBox(new Point(xCenter-(width/2),yCenter+(height/2)),new Point(xCenter+(width/2),yCenter-(height/2)));

    }

    /* Invokes setting up BB for Rect using basic calculations to derive points */
    private void setupBoundingBox() {
        this.boundingBox = new BoundingBox(
                        (new Point
                                            ((xCenter-(width/2)), (yCenter+(height/2)))),
                        new Point
                                            ((xCenter+(width/2)),(yCenter-(height/2))));
    }

    /* getter to derive center point (x, y) */
    public Point getRectCenterPoint() {
        return new Point(this.xCenter, this.yCenter);
    }



    /* getter to check filled bool */
    public boolean getFilled(){
        return filled;
    }

    /* This method is overridden via the abstract Shape class & it checks if
     * a Rect is filled or not (bool) and proceeds to display on the gui */
    @Override
    public void drawShape(Graphics g) {
        /* vars passed in as args in */
//        System.out.println(this.toString()); // the 'shapes' object (just console)
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(1));

        /* offset center x & y to get actual shape */
        int pointX = (xCenter - (width/2)); // so if X = 200 and width = 80- > 200 - (80/2) = 160 (offsetting center)
        int pointY = (yCenter - (height/2)); // height is on Y axis, to find center point
//        System.out.println("this is point x (should be 160): " + pointX + ". This should be point y (120): " + pointY);

        /* check if filled (via mouse click toggle) */
        if (filled) {
            g.fillRect(pointX, pointY, width, height);
        }

        else {
            g.drawRect(pointX, pointY, width, height);
            }
        }


    /* method invoked via right click - check shape right click override method */
    @Override
    public boolean rightClick() {
        /* calls the move10units method below */
        moveTenUnits();
        return true;

    }
    /* This method is overridden via the moveable interface,
    * once invoked we simply move the Rect in BB by 10 units */
   @Override
    public void moveTenUnits() {

       boundingBox.BBAddTenToBottomLeftX(); // OOP
       boundingBox.BBAddTenToTopRightX();
       xCenter += 10;


       /* I left this old, error ridden commented code below in as
       * I learned a lot about OOP messing around with trying
       * to access the attributes (BB and Point)  */

//        boundingBox.getBottomLeft().addTenToX();
//        boundingBox.getTopRight().addTenToX();
//       boundingBox.bottomLeft.addTenToY();
//         xCenter += 10;

        /* shift 3 x-points x10 to the right -> */
       //access points
//       Point bottomLeftPoint = boundingBox.getBottomLeft();
//       int bottomLeftX = bottomLeftPoint.getX();
//       bottomLeftX += 10; // bottom left x 10
//       Point topRightPoint = boundingBox.getTopRight();
//       int topRightY = topRightPoint.getY();
//       topRightY += 10;
//       xCenter += 10;
//       System.out.println("this is BB - xCenter: " + xCenter);

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
