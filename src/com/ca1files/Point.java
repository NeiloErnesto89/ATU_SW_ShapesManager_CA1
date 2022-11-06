package com.ca1files;

public class Point {

    /* Point class used to store x,y co-ords */
    private int x;
    private int y;
    
    /* empty default constructor */ 
    public Point () {
        
    }
    
    /* constructor */
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*  get X int */
    public int getX() {
        return this.x;
    }

    /*  get Y int */
    public int getY() {
        return this.y;
    }

    /* important getter for MoveTenUnits method
    * via BB class + Shape (Rect) upon leftClick */
    public int getXPlusTen(){

        return this.x +=10;
    }

    /*  set X int */
    public void setX(int x) {
        this.x = x;
    }

    /*  set Y int */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
