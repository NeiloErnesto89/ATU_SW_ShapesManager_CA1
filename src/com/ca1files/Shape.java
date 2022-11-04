package com.ca1files;


import java.awt.*;

/* in inheritance hierarchy - Shape class is abstract  */
public abstract class Shape {

    /* Shape Class Instance Fields - 'not exhaustive'
    * these are common attributes/characteristics shapes have */
    protected Color color; // Color class in java.awt - 01/11/22
    protected boolean filled;
    protected int xCenter, yCenter; // shapes define via center of object

    /* BB attr */
    BoundingBox boundingBox; // display True

    /* FYI - 44.31 in Class 3 - draw in the center is to divide the length and width of the object by 2
    * we need to provide correct co-ords e.g. center of rec in (300, 200) for a rec of l=60, w=40
    * so we move backward by half the width (40/2 = 20 -> 300 - 20 = 280), then move up by half the height
    * (as y points down), so 60/2 = 30 -> 200 - 30  = 170*/

    /* There, we have access to width and height in object, plus center point, so
    * when we call g -> we subtract half the width and half the height 44m50*/

    /* Add constructor -> MAYBE DEFAULT - 01/11/22 */
    public Shape(Color color, boolean filled, int xCenter, int yCenter) {
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }


//    public Shape() {
//        // default needed or overloaded consttructor in subclasses
//
//    }
    //    https://github.com/DermoHiggs/SW_Development_Autumn2021/blob/master/src/sw_dev/inheritance/exercises/exercise2_2/Shape.java

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

    /* mouse click method */
    public boolean rightClick() {return false;}

    /* BB method - takes graphics param and we call drawRect (as BB also just a shape)
    * each shape should have a BB */
    public void drawBoundingBox (Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        /* via RoadMap notes -  */

        Graphics2D g2d = (Graphics2D) g;

        float[] dash1 = { 2f, 0f, 5f };
//        g2d.drawLine(20, 40, 250, 40);
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
//        System.out.println(boundingBox.getBoundingBox()); // make static

        /* Tester to check if I can access bottomLeft.x and check if output is correct */
        Point bottomLeftPoint = boundingBox.getBottomLeft(); // looking for bottomLeft => if XCenter = 275 & radius = 150 -> (275 - (150/2)) = 275 - 75 = 200 (correct)
        int bottomLeftX = bottomLeftPoint.getX();
//        System.out.println("this X point be: 200 (if XCenter = 275 and Radius is 150). Therefore X == "+ bottomLeftX);
        Point topRightPoint = boundingBox.getTopRight();
        int topRightY = topRightPoint.getY();
//        System.out.println("this Y point should be: 375: "+ topRightY); // if Y = 300 + (150/2) = 300-75 = 375
        /* WE NEED TO RESOLVE BB DERIVED WIDTH AND HEIGHT */
        int topRightX = topRightPoint.getX();
        int bottomLeftY = bottomLeftPoint.getY();
        System.out.println("(X1: "+ bottomLeftX + ", Y1: " + bottomLeftY + ")");
        System.out.println("(X2: "+ topRightX + ", Y2: " + topRightY + ")");

        int derivedWidth = topRightX - bottomLeftX; // X axis for width - x1 - x2 - 350 - 200 = 150 (width)
        int derivedHeight = bottomLeftY - topRightY; // Y axis for height - y1 - y2 - 375 - 225 = 150 (height)
        System.out.println(" Bottom Left X = " + bottomLeftX + ". Top Right Y = " + topRightY + " Top Right X = " + topRightX + " Bottom Left Y = " + bottomLeftY );
        System.out.println("width= " + derivedWidth + " height: "+ derivedHeight);
        g2d.drawRect(bottomLeftX, topRightY, derivedWidth, derivedHeight); // this works!


//        Point x = boundingBox.getBottomLeft();
//        System.out.println("this is x: "+ x);
//        int pointX = this.boundingBox.getBottomLeft()[0];
//        g2d.drawRect(topRightX, bottomLeftY, 250, 80);
//        g2d.drawRect();
    }



    /* provide (at least) the following abstract method(s) */

    public abstract void drawShape (Graphics g);

    public void drawName(Graphics g) {
        g.setColor(Color.black);
        Font textFont = new Font("SansSerif", Font.ITALIC, 14);
        g.setFont(textFont);
//        g.getFontMetrics();

        /* via Dermot doc - CA RoadMap:  o get the class name (Circle, Rectangle, etc.) you can use getClass().getSimplename().
        *Below is an (illustrative) example.
        * //There are mechanisms for us to access the class type from an object instance
             System.out.println(ob1.getClass().getSimpleName());
             System.out.println(ob1.getClass().getName()); // includes
            package information
        */
        /* reflection -> info inside object at compile time */
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
