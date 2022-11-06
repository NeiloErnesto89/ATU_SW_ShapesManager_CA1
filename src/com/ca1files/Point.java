package com.ca1files;

public class Point {

    /* Point class  (class 3 - 49m10) to store x,y co-ords
    * * issues with BB so removed private  */
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

//    public Point(int i, int i1, int i2, int i3) {
//    }

    public int getX() {
        return this.x;
    }

    /* getter for MoveTenUnits method == move BB + Shape upon rightClick*/
    public int getXPlusTen(){
        return this.x +=10;
    }
//
//    public int addTenToX() {return this.x + 10; }
//
    public int getY() {
        return this.y;
    }
//
//    public int addTenToY() {return this.y + 10; }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
