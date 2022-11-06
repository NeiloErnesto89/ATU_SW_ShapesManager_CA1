package com.ca1files;

import javax.swing.*;
import java.awt.*;

/* The window creator class creates the shape objects, adds them to the ShapeManager
* object to be called and drawn to the GUI. */

public class WindowCreator {
    /* method is called in the Tester and builds the shapes on the GUI */
    public static void buildWindow() {
        /* creating circle objects */
        Circle c1 = new Circle(Color.ORANGE, true, 250, 300, 140 );
        Circle c2 = new Circle(Color.PINK,false,400,300,180);

        /* creating a rectangle object */
        Rectangle r1 = new Rectangle(Color.green, true, 150, 200, 120, 100 );

        /* creating a square object */
        Square sq1 = new Square(Color.CYAN, true, 110, 150, 100); // sides


        /* Dermots Tester via BlackBoard */

        Point[] quadVertices = {
                new Point(50,50),
                new Point(120, 70),
                new Point(100, 120),
                new Point(40, 90)
        };

        Point rotatePointInCenter = new Point(80,80); //For test 1
        Quadrilateral quad1 = new Quadrilateral(Color.BLUE, true,  rotatePointInCenter, quadVertices);


        /* creating Quadrilateral object via method 1 (passing in points array) */
        Point cP1 = new Point(220,160);
        Point[] points = new Point[4];
        points[0] = new Point(200,80); //topLeft
        points[1] = new Point(250,80); // bottomRight
        points[2] = new Point(250,190); // topRight
        points[3] = new Point(175,215); // bottomLeft
        Quadrilateral q1 = new Quadrilateral(Color.ORANGE,false, cP1, points);

        /* creating Quadrilateral object via method 2 (passing in individual points) */
        Point cp2 = new Point(480, 320);
        Point p1 = new Point(520,340);
        Point p2 = new Point(540,300);
        Point p3 = new Point(400,280);
        Point p4 = new Point(450,350);
        Quadrilateral q2 = new Quadrilateral(Color.yellow,true, cp2, p1, p2, p3, p4);

        /* creating Quadrilateral object via method 3 (passing in Rectangle object) */
        Rectangle r2 = new Rectangle(Color.white,false,400,70,50,40);
        Quadrilateral q3 = new Quadrilateral(Color.red,true, r2);

        // adding to shapes arrayList to be looped over and draw on panel
        guiTester.shapesManager.addShape(c1);
        guiTester.shapesManager.addShape(c2);
        guiTester.shapesManager.addShape(r1); // didn't incorporate BB for Rect so null pointer
        guiTester.shapesManager.addShape(quad1); //Dermot's tester test1
        guiTester.shapesManager.addShape(q1);
        guiTester.shapesManager.addShape(q2);
        guiTester.shapesManager.addShape(q3);
//        guiTester.shapesManager.addShape(q3);
//        guiTester.shapesManager.addShape(sq2);
    }

}
