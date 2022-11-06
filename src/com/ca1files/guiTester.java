package com.ca1files;

import javax.swing.*; // import all from Java swing
import java.awt.*;
//
//import static java.awt.Color.red;

/* Gui Tester class -> create test shape objects
* via WindowCreator class */

public class guiTester {

    /* global shapesManager object */
    static ShapesManager shapesManager = new ShapesManager();

    public static void main(String[] args) {

        /* calling build method via WIndowCreator class
        * which contains shape obj and adds the test shapes to the SM list */
        WindowCreator.buildWindow();

        shapesManager.setDisplayName(true);
        shapesManager.setDisplayBoundingBox(true);


        /* passing SM in as arg to new Custom Window object to set up Jframe */
        CustomWindow customWindow = new CustomWindow(shapesManager);

        /*  set windows width and height via Consts file */
        customWindow.setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);

        /*  the title on the toolbar of frame (my name & student number) */
        customWindow.setTitle("CA1 Shapes: Neil Smyth (L00177606) ");

        /*  window visibility = True */
        customWindow.setVisible(true);

        /*  unused opacity setter */
//        customWindow.setOpacity(1.0f);

        /*  if user clicks 'X;, program stops and window closes down */
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
