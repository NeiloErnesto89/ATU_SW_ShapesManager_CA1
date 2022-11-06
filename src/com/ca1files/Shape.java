package com.ca1files;

import java.awt.*;

/* in inheritance hierarchy - Shape class is abstract and the
* base class to build all other shapes  */
public abstract class Shape {

    /* Shape Class Instance Fields - 'not exhaustive'
    * these are common attributes/characteristics shapes have */
    protected Color color; // Color class in java.awt
    protected boolean filled;
    protected int xCenter, yCenter; // shapes define via center of object

    /* BB attr */
    BoundingBox boundingBox; // display True

    /*  Constructor for Shape class  */
    public Shape(Color color, boolean filled, int xCenter, int yCenter) {
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }


    /* provide (at least) the following abstract method(s) */
    public abstract void drawShape (Graphics g);

    /* getters & setters for color and filled boolean  */

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /* method below allows us to toggle the filled bool  */
    public void toggleFilled() {
        filled =! filled; // not equal operator -
    }

    /* right mouse click method */
    public boolean rightClick() {return false;}

    /* BB method - takes graphics param and we call drawRect (as BB also just a shape)
    * each shape should have a BB */
    public void drawBoundingBox (Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        Graphics2D g2d = (Graphics2D) g;
        float[] dash1 = { 2f, 0f, 5f };
        BasicStroke bs1 = new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash1,
                2f);

        g2d.setStroke(bs1);

        /* here we must set BB dimensions via logical deduction
        * via marking scheme: Show each Shapes’s BoundingBox based on
        * a Boolean variable (initialised at compile-time)*/

        /* Tester to check if I can access bottomLeft.x and check if output is correct */
        Point bottomLeftPoint = boundingBox.getBottomLeft(); // looking for bottomLeft => if XCenter = 275 & radius = 150 -> (275 - (150/2)) = 275 - 75 = 200 (correct)
        int bottomLeftX = bottomLeftPoint.getX();

        Point topRightPoint = boundingBox.getTopRight(); //System.out.println("this X point be: 200 (if XCenter = 275 and Radius is 150). Therefore X == "+ bottomLeftX);
        int topRightY = topRightPoint.getY();

        int topRightX = topRightPoint.getX();
        int bottomLeftY = bottomLeftPoint.getY();

        int derivedWidth = topRightX - bottomLeftX; // X axis for width - x1 - x2 - 350 - 200 = 150 (width)
        int derivedHeight = bottomLeftY - topRightY; // Y axis for height - y1 - y2 - 375 - 225 = 150 (height)
//        System.out.println("width= " + derivedWidth + " height: "+ derivedHeight);
        g2d.drawRect(bottomLeftX, topRightY, derivedWidth, derivedHeight); // this works!

    }
    /* overridden draw name method   */
    public void drawName(Graphics g) {
        g.setColor(Color.black);
        Font textFont = new Font("SansSerif", Font.ITALIC, 14);
        g.setFont(textFont);
//        g.getFontMetrics();

        /* via Dermot doc - CA RoadMap:  o get the class name (Circle, Rectangle, etc.) you can use getClass().getSimplename()
        * reflection -> info inside object at compile time */
        g.drawString(this.getClass().getSimpleName(),xCenter,yCenter);
    }


    /* Override ToString for Debugging purposes (console) - 01/11/22 */
    @Override
    public String toString() {
        return "Shape{" +
                "color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }


}
