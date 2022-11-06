package com.ca1files;

/* 03/11/22 - comment */

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
/**
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */
public class CustomPanel extends JPanel {


    /* instance field is reference to Shapes Manager Object
     * via that - we call ShapesManger.drawShapes()
     * we do this so Custom Panel can communicate with Shapes Manager  */
    ShapesManager shapesManager;
    /* constructor sets up instance field and stores object away */
    public CustomPanel(ShapesManager shapesManger) {
        this.shapesManager = shapesManger;

        /* Mouse Click Video  7m39
         * MouseListener is interface
         * MouseAdapter implements listener for us
         * so we don't have to override
         * Anon Class */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);

                System.out.println(e.toString());
                /* capture mouse click X & Y Co-ords*/
                int mouseX = e.getX();
                int mouseY = e.getY();

//                int clickCount = e.getClickCount();


                /* button check - 1 is left click & 3 is right */

                /* via Dermot 15.00 - mouse click video 2 */

//                int modifier = e.getModifiersEx();
//                if ((modifier & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK ) { // 1024
//                    System.out.println("this is modifier: " + modifier + ". This is inputEvent.button1: " + InputEvent.BUTTON1_DOWN_MASK);
//                }

                int button = e.getButton(); // left click == 1 & right click == 3 (FYI: middle button == 2)

                boolean mouseCheck1 = false;
                boolean mouseCheck3 = false;
                if (button == 1) {
                    System.out.println("Right click pressed ");
                    mouseCheck1 = shapesManger.leftClick(mouseX, mouseY); // bool method returns true
                }


                else if (button == 3)
                {
                    System.out.println("Right click pressed ");
                    mouseCheck3 = shapesManger.rightClick(mouseX, mouseY);
                }
//                else if (button == 2) {
//                    System.out.println("You have pressed the middle button! No functionality has been added here ..Yet!");
//                }

                if (mouseCheck1 || mouseCheck3) {//if True && True - logic AND gate
                    /* here if left mouse clicker pressed && inside a shape
                     * we invoke the repaint method */
                    repaint();
                }
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        //The superclass does some important work in the method we've overridden, so we
        //should invoke it.
        super.paintComponent(g);
        shapesManager.drawShapes(g);

        
//        g.setColor(Color.blue);
        //Here's an example of a shape.
        //For our panels, the origin (0,0) is the top left corner
        //This means that the +ve Y axis is "down", i.e. it's the opposite
        //of the familiar cartesian coordinate system.
//        g.drawRect(5,20, 40,60);
        //Exercises:
        //1: Draw an oval that fits exactly within the rectangle above
        //2: Draw an oval that fills the entire panel. NOTE: the panel
        // class has getters for its width and height.
        //3: Draw a circle of radius 25 that is centered in the center of
        // the panel. Make the window bigger/smaller and
        // verify that it remains centered.
        //4: See if you can find (using intellisense) the method required to
        // draw a filled version of the circle from exercise 3.
//        g.setColor(Color.red);
//        int circleRadius = 25;
//        g.drawOval(this.getWidth()/2 - circleRadius,
//                this.getHeight()/2 - circleRadius,
//                circleRadius * 2,
//                circleRadius*2);
    }
}