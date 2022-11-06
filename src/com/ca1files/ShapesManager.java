package com.ca1files;

import java.awt.*;
import java.util.ArrayList;

/* This class is used to create shapes objects
 * rather than draw shapes directly (e.g paintComponent)
 * we use a ShapesManager to store 'a list of shape'.
 * We do this so we can iterate through list to check if
 * a mouse-click intersects with any shapes bounding-box
 * maintains arraylist of shape objects: then
 * we can call add shape() */

public class ShapesManager {

    /* here we store child class shapes in list */
    private ArrayList<Shape> shapes = new ArrayList<>();

    /* maintain two boolean fields (and associated getters/setters) to allow the features to be turned on/off*/
    private boolean displayName = true;
    private boolean displayBoundingBox = true;

    public void addShape(Shape shapeToAdd) {
        /* simply adds given shapeTOAdd arg to ArrayList
        * utilises add() from ArrayList object -> to get shapes into arrayList
        * Appends the specified element to the end of this list. (via https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) */
        shapes.add(shapeToAdd);
//        shapes.size()
    };

    /* overridden drawShapes method  will iterate (loop) over list & call each
     * shape's drawShape() (which is the abstract method in Shapes class) */
    public void drawShapes(Graphics graphicsContext) {

            /* enhanced for loop iterates over list of shapes and draws */

            for (Shape shape : shapes) {
                shape.drawShape(graphicsContext);

                /* check if BB is true */
                if (displayBoundingBox)
                    shape.drawBoundingBox(graphicsContext);

                /* displayName if true, invoke graphics context */
                if (displayName)
                    shape.drawName(graphicsContext);
                }

            }

    /* get and set methods for boolean
    * and we can enable/disable withing main()*/

    public boolean isDisplayName() {
        return displayName;
    }

    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    public boolean isDisplayBoundingBox() {
        return displayBoundingBox;
    }

    public void setDisplayBoundingBox(boolean displayBoundingBox) {
        this.displayBoundingBox = displayBoundingBox;
    }


    /* leftClick is checking if left mouse click was inside a shape
    * we return a bool depending on the outcome */
    public boolean leftClick(int mouseX, int mouseY) {

        boolean inBounds = false;

        /* enchanced for loop over shapes */
        for (Shape shape : shapes) {
////            System.out.println(shape);
            /* we extract co-rds and assign individually  */
            Point bottomLeftCoOrds = shape.boundingBox.getBottomLeft();
            Point topRightCoOrds = shape.boundingBox.getTopRight();
            int xOne = bottomLeftCoOrds.getX(); // x1
            int yOne = bottomLeftCoOrds.getY(); // y1
            int xTwo = topRightCoOrds.getX(); // x2
            int yTwo = topRightCoOrds.getY(); // y2

            /* mouseClick >= x1 && MouseClick <= x2; -> basically we are checking if
             * the Mouse Click has occurred is in the shape. If so, we invoke
             *  toggleFilled() method to flip between filled =! filled
             * if X Cord is greater than or equal to x1 and X Cord is less than or equal to x2
             * XMouse = 163 >= x1 (25) == True && xMouse 163 <= 175 == True && */
            if ( (mouseX>=xOne && mouseX<=xTwo ) && (mouseY>=yTwo && mouseY<=yOne)) {

            /* condition is true so we invoke toggle filled method */
                System.out.println("True - left click occurred inside shape");
                shape.toggleFilled();
                inBounds = true;
                }
            }
        /* returns bool */
        return inBounds;
    }

    /* rightClick is checking if left mouse click was inside a shape
     * we return a bool depending on the outcome */
    public boolean rightClick(int mouseX, int mouseY) {

        boolean inBounds = false;

        /* loop over shapes */
        for (Shape shape : shapes) {
;
            Point bottomLeftCoOrds = shape.boundingBox.getBottomLeft();
            Point topRightCoOrds = shape.boundingBox.getTopRight();
            int xOne = bottomLeftCoOrds.getX(); // x1
            int yOne = bottomLeftCoOrds.getY(); // y1
            int xTwo = topRightCoOrds.getX(); // x2
            int yTwo = topRightCoOrds.getY(); // y2

            /* mouseClick >= x1 && MouseClick <= x2; -> basically we are checking if
             * the Mouse Click has occurred is in the shape. If so, we invoke
             *  toggleFilled() method to flip between filled =! filled
             * if X Cord is greater than or equal to x1 and X Cord is less than or equal to x2
             * XMouse = 163 >= x1 (25) == True && xMouse 163 <= 175 == True && */
            if ( (mouseX>=xOne && mouseX<=xTwo ) && (mouseY>=yTwo && mouseY<=yOne)) {

                System.out.println("True - right click occurred inside shape");
                /* here we invoke method associated with particular shape (move for rect/square or rotate for quad)  */
                shape.rightClick();
                inBounds = true;
            }
        }
        return inBounds; // returns bool - true or false to invoke method

    }

}
