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


        Point centerPoint1 = new Point(230,150);
        Point[] points = new Point[4];
        points[0] = new Point(200,100);
        points[1] = new Point(260,90);
        points[2] = new Point(260,200);
        points[3] = new Point(190,210);
        Quadrilateral q1 = new Quadrilateral(Color.green,true, centerPoint1, points);

        Point centerPoint2 = new Point(480, 320);
        Point p1 = new Point(520,340);
        Point p2 = new Point(540,300);
        Point p3 = new Point(400,280);
        Point p4 = new Point(450,350);
        Quadrilateral q2 = new Quadrilateral(Color.RED,true, centerPoint2, p1, p2, p3, p4);


//        Square sq2 = new Square(Color.red, true, 150, 240, 80, 80 );

//        Square sq2 = new Square(Color.RED, true, 150,240, 80);

        guiTester.shapesManager.addShape(c1); // adding to shapes arrayList to be looped over
        guiTester.shapesManager.addShape(c2);

        guiTester.shapesManager.addShape(r1); // didn't incorporate BB for Rect so null pointer
//        guiTester.shapesManager.addShape(sq1);
        guiTester.shapesManager.addShape(q1);
        guiTester.shapesManager.addShape(q2);
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
