package com.ca1files;

import javax.swing.*;
import java.awt.*;
/**
 * Via Dermot - Prerequisites files
 * We can think of a JFrame as a window
 * By extending (inheriting from) the class javax.swing.JFrame we can
 * define what goes into our window - in this case a single JPanel which is
 * a component container for GUI elements.
 */
public class CustomWindow extends JFrame {

    private CustomPanel mainPanel;
    public CustomWindow(ShapesManager shapesManager)
    {
        CustomPanel mainPanel = new CustomPanel(shapesManager); //CustomPanel type expecting shapesManager obj
        /* adding the mainPanel obj with SM to the pane;*/
        add(mainPanel, BorderLayout.CENTER);

    }
}
