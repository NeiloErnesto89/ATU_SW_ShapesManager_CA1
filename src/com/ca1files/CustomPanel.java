package com.ca1files;

/* some imports unused and commented out */

import javax.swing.*;
import java.awt.*;
//import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;


/**
 * --------- Boiler Plate Code via Dermot's files  ----
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */
public class CustomPanel extends JPanel {

    /* instance field is a reference to Shapes Manager Object
     * so that we can call ShapesManger.drawShapes()
     * we do this so Custom Panel can communicate with Shapes Manager  */
    ShapesManager shapesManager;

    /* constructor sets up instance field and stores object away */
    public CustomPanel(ShapesManager shapesManger) {
        this.shapesManager = shapesManger;

        /* MouseListener is interface/anon class
         * MouseAdapter implements listener for us
         * therefore, we don't have to override */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);

                System.out.println(e.toString());
                /* capture mouse click X & Y Co-ords*/
                int mouseX = e.getX();
                int mouseY = e.getY();

                /*  Commented & unused code */
//                int clickCount = e.getClickCount();
//                int modifier = e.getModifiersEx();
//                if ((modifier & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK ) { // 1024
//                    System.out.println("this is modifier: " + modifier + ". This is inputEvent.button1: " + InputEvent.BUTTON1_DOWN_MASK);
//                }

                /* mouse click button check -->  1 is left click & 3 is right. 2 is the middle (roller) button
                * below we assign a button var this getButton() to get number  */
                int button = e.getButton(); // left click == 1 & right click == 3

                /* Code below sets some vars as false bools and checks some conditions
                * if conditions are True, then we invoke the repaint() method
                * which in turns invokes a method (depending on the shape and click) */
                boolean mouseCheck1 = false;
                boolean mouseCheck3 = false;

                if (button == 1) {
                    System.out.println("Left click pressed ");
                    mouseCheck1 = shapesManger.leftClick(mouseX, mouseY); // bool method returns true
                }

                else if (button == 3)
                {
                    System.out.println("Right click pressed ");
                    mouseCheck3 = shapesManger.rightClick(mouseX, mouseY);
                }
                /* we could potentially configure some logic for the button 2 click*/
//                else if (button == 2) {
//                    System.out.println("You have pressed the middle button! No functionality has been added here ..Yet!");
//                }

                /*  True && True -> logic OR gate. Either can evaluate to True */
                if (mouseCheck1 || mouseCheck3) {
                    /* here if left mouse clicker pressed && inside a shape
                     * we invoke the repaint method */
                    repaint();
                }
            }
        });
    }

    /* paint component override */
    @Override
    protected void paintComponent(Graphics g) {
        //The superclass does some important work in the method we've overridden, so we
        //should invoke it.
        super.paintComponent(g);
        shapesManager.drawShapes(g);

    }
}