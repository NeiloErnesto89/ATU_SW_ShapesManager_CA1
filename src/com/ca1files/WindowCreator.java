package com.ca1files;

import javax.swing.*;
import java.awt.*;

/* 03/11/22 - comment */

public class WindowCreator {
    public static void buildWindow() {
        Circle c1 = new Circle(Color.ORANGE, true, 280, 300, 150 );
        guiTester.shapesManager.addShape(c1); // adding to shapes arrayList to be looped over

        Rectangle r1 = new Rectangle(Color.magenta, false, 200, 220, 80, 200 );
        guiTester.shapesManager.addShape(r1);
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
