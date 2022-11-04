package com.ca1files;

/* This class is used to create shapes objects
* rather than draw shapes directly (e.g paintComponent)
* we use a ShapesManager to store 'a list of shape'.
* We do this so we can iterate through list to check if
* a mouse-click intersects with any shapes bounding-box
* 01/11/22 - maintains arraylist of shape objects: then
* we can call add shape()
*  */

import java.awt.*;
import java.util.ArrayList;

public class ShapesManager {

//    private ArrayList<Shape> shapes; // we can store any subclass of shape here e.g. circle

    // 1h01m23 - class 3 init with constructor but in a hurry
    private ArrayList<Shape> shapes = new ArrayList<>();

    /* 03/11/22 - Road Map doc
    * /* maintain two boolean fields (and associated getters/setters) to allow the features to be turned on/off*/
    private boolean displayName = true;
    private boolean displayBoundingBox = true;

    public void addShape(Shape shapeToAdd) {
        /* simply adds given shapeTOAdd arg to ArrayList
        * utilises add() from ArrayList object -> to get shapes into arrayList
        * * Appends the specified element to the end of this list. (via https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) */
        shapes.add(shapeToAdd);
//        shapes.size()
    };

    public void drawShapes(Graphics graphicsContext) {

        /* method will iterate (loop) over list  & call each shape's
        * drawShape() (which is the abstract method in Shapes class) */

        /* if True */

            /* for loop iterates over list of shapes and draws */
            for (Shape shape : shapes) {
                shape.drawShape(graphicsContext);

                /* Class 5 - 1hr24 - if true, invoke graphics conext */
                if (displayName) {
                    shape.drawName(graphicsContext);
                }
                if (displayBoundingBox) {
                    shape.drawBoundingBox(graphicsContext);
                }
            }

        /* enhanced for loop 1hr05m55 */

//        for( Shape currShape:shapes ) {
//            currShape.drawShape(null);
//        }
//        for (Shape currShape :
//                shapes) {
//            currShape.drawShapeConsole();
//        }

    }

    /* Class 5 - 1hr21m10 - get and set methods for boolean
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

    //    @Override
//    protected void paintComponent (Graphics g);

    // should have an ADDShape function to store objects to list
}
