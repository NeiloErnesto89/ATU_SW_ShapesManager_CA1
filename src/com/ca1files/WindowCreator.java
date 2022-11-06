package com.ca1files;

import javax.swing.*;
import java.awt.*;

/* 03/11/22 - comment */

public class WindowCreator {
    public static void buildWindow() {
        Circle c1 = new Circle(Color.ORANGE, true, 280, 300, 150 );

        Circle c2 = new Circle(Color.PINK,true,400,280,170);

        Rectangle r1 = new Rectangle(Color.green, false, 150, 200, 120, 100 );

        Square sq1 = new Square(Color.CYAN, true, 110, 150, 100); // error as we height + width should always be the same

        //        Square sq2 = new Square(Color.red, true, 150, 240, 80, 80 );

//        Square sq2 = new Square(Color.RED, true, 150,240, 80);


        Point centerPoint1 = new Point(230,150);
        Point[] points = new Point[4];
        points[0] = new Point(200,100); //topLeft
        points[1] = new Point(260,90); // bottomRight
        points[2] = new Point(260,200); // topRight
        points[3] = new Point(190,210); // bottomLeft
        Quadrilateral q1 = new Quadrilateral(Color.green,true, centerPoint1, points);

        Point centerPoint2 = new Point(480, 320);
        Point p1 = new Point(520,340);
        Point p2 = new Point(540,300);
        Point p3 = new Point(400,280);
        Point p4 = new Point(450,350);
        Quadrilateral q2 = new Quadrilateral(Color.RED,true, centerPoint2, p1, p2, p3, p4);


//        Rectangle r2 = new Rectangle(Color.white,true,380,60,40,50); // colour light or white and not filled
//        Quadrilateral q3 = new Quadrilateral(Color.yellow,true, r2); // color overrides from Rect
//        Rectangle r2 = new Rectangle(Color.cyan,true,380,60,40,150);
//        Quadrilateral q4 = new Quadrilateral(r2);

        Rectangle rect2 = new Rectangle(Color.white,false,400,70,50,40);
        Quadrilateral q44 = new Quadrilateral(Color.yellow,true, rect2);


        guiTester.shapesManager.addShape(c1); // adding to shapes arrayList to be looped over
        guiTester.shapesManager.addShape(c2);

        guiTester.shapesManager.addShape(r1); // didn't incorporate BB for Rect so null pointer
//        guiTester.shapesManager.addShape(sq1);
        guiTester.shapesManager.addShape(q1);
        guiTester.shapesManager.addShape(q2);
        guiTester.shapesManager.addShape(q44);
//        guiTester.shapesManager.addShape(q3);
//        guiTester.shapesManager.addShape(sq2);
    }
//    public static void main(String[] args) {
//
//        //Create and configure our JFrame (window)
//        CustomWindow customWindow = new CustomWindow();
//        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        customWindow.setTitle("Test Window");
//        customWindow.setVisible(true);
//    }
}
