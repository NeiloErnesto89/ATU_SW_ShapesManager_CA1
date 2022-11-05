package com.ca1files;

import javax.swing.*;
import java.awt.*;

/* 03/11/22 - comment */

public class WindowCreator {
    public static void buildWindow() {
        Circle c1 = new Circle(Color.ORANGE, true, 280, 300, 150 );

        Circle c2 = new Circle(Color.PINK,true,300,280,150);

        Rectangle r1 = new Rectangle(Color.green, true, 100, 200, 40, 200 );

        Square sq1 = new Square(Color.CYAN, true, 80, 50, 100, 100);

        guiTester.shapesManager.addShape(c1); // adding to shapes arrayList to be looped over
        guiTester.shapesManager.addShape(c2);

        guiTester.shapesManager.addShape(r1); // didn't incorporate BB for Rect so null pointer
        guiTester.shapesManager.addShape(sq1);
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
