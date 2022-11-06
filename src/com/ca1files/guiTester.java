package com.ca1files;

import javax.swing.*; // import all from Java swing
import java.awt.*;
//
//import static java.awt.Color.red;

/* Tester class -> create object */

public class guiTester {

    /* global shapesManager object */
    static ShapesManager shapesManager = new ShapesManager();


    public static void main(String[] args) {

        /* calling build method via WIndowCreator class which adds the test shapes to the SM list*/

        WindowCreator.buildWindow();

        shapesManager.setDisplayName(true);
        shapesManager.setDisplayBoundingBox(false);

//        Rectangle r1 = new Rectangle(Color.red,false,50,120,50,200);
//
//        shapesManager.addShape(r1);



        /* passing SM in as param to new Custom Window object to set up Jframe */
//        new CustomWindow(shapesManager);
        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
        customWindow.setTitle("CA1 Shapes: Neil Smyth (L00177606) ");
        customWindow.setVisible(true);
//        customWindow.setOpacity(1.0f);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* via ShapeManager class - access via setter methods
        * for loop to check if set? */
         //calling - BB in Circle test

//        for (shapesManager shapes: shapes) {


        // here create new ShapesManager objects
        // try create Circle shape and add to mngr

//        ShapesManager shapesList = new ShapesManager();
//        shapesList.drawShapes(g);

//        ShapesManager shapesManager = new ShapesManager();
//        shapesManager.addShape(new Rectangle( red, true, 50, 50 , 20, 40));
//
//        shapesManager.drawShapes(null);

        //finished this step class 3 @ 1h09m22


        //Create our window and pass in our manager - ( configure our JFrame (window))
//        CustomWindow customWindow = new CustomWindow();
//        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        customWindow.setTitle("Test Window");
//        customWindow.setVisible(true);



    }
}
