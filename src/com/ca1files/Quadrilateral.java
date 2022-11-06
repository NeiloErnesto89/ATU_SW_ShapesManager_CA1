package com.ca1files;

/* implements rotatable interface */

import java.awt.*;
import java.util.ArrayList;

/* inherits from Shape so has a Center point
* we will use it for rotation, so Quad class
* also implements Rotatable Interface */
public class Quadrilateral extends Shape implements Rotatable {

    private Point[] points = new Point[4]; // set Array to len 4


    /* this constructor we pass in an arrayList to loop over and assign points depending on conditions */
    public Quadrilateral(Color color, boolean filled, Point centerPoint, Point[] pointsList) {
        super(color, filled, centerPoint.getX(), centerPoint.getY());

        /* vars for 4 points of quad */
        Point topLeftPoint = new Point();
        Point topRightPoint = new Point();
        Point bottomLeftPoint = new Point();
        Point bottomRightPoint = new Point();

        /* using centerPoint(x,y) as origin and deriving points from there
        * and assign point via conditionals */
        for (Point point: pointsList) {
            if (point.getX() <= centerPoint.getX() && point.getY() >= centerPoint.getY()){
                bottomLeftPoint = point;
            }
            if (point.getX() >= centerPoint.getX() && point.getY() <= centerPoint.getY()){
                topRightPoint = point;

            }
            if (point.getX() <= centerPoint.getX() && point.getY() <= centerPoint.getY()){
                topLeftPoint = point;
            }
            if (point.getX() >= centerPoint.getX() && point.getY() >= centerPoint.getY()){
                bottomRightPoint = point;
            }

        }
        /* checking the point tuples */
        System.out.println("bottomLeftPoint = " + bottomLeftPoint);
        System.out.println("topRightPoint = " + topRightPoint);
        System.out.println("bottomRightPoint = " + bottomRightPoint);
        System.out.println("topLeftPoint = " + topLeftPoint); //

        /* assigning derived point to this.object vars to list (via index) */
        this.points[0] = topLeftPoint;
        this.points[1] = topRightPoint;
        this.points[2] = bottomRightPoint;
        this.points[3] = bottomLeftPoint;

        /* Invoked new Bounding Box method here */
        setQuadBoundingBox(this.points);

    }


    /* Constructor for Quad specific 4 points - centerpoint(x,y) - extracted via getters */

    public Quadrilateral(Color color, boolean filled, Point centerPoint, Point point1, Point point2, Point point3, Point point4) {
        super(color, filled, centerPoint.getX(), centerPoint.getY());

        /* vars for 4 points of quad */
        Point topLeftPoint = new Point();
        Point topRightPoint = new Point();
        Point bottomLeftPoint = new Point();
        Point bottomRightPoint = new Point();

//        this.points.add(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);

        Point[] vertexList = {point1, point2, point3, point4};

        for (Point vertex: vertexList) {
            System.out.println("these are the vertex: "+ vertex);

        }

        topLeftPoint = vertexList[0];
        topRightPoint = vertexList[1];
        bottomLeftPoint = vertexList[2];
        bottomRightPoint = vertexList[3];

        this.points[0] = topLeftPoint;
        this.points[1] = topRightPoint;
        this.points[2] = bottomLeftPoint;
        this.points[3] = bottomRightPoint;

        /* Invoked new Bounding Box method here */
        setQuadBoundingBox(this.points);

    }

    private void setQuadBoundingBox(Point[] points) {
        /* here we find the mix-max for (x,y) co-ords*/
        int minX = points[0].getX(); // getter for X
        int maxX = points[1].getX();
        int minY = points[2].getY();
        int maxY = points[3].getY();

        /* loop over points list and assign points based on derived bounds */

        for (Point point: points) {

            if (point.getX() < minX) { //check if point is less than min required
                minX = point.getX(); // reassign minX
            }
            if (point.getY() < minY) { //check if point is less than min required
                minY = point.getY(); // reassign minX
            }

            if (point.getX() > maxX) { //check if point is less than min required
                maxX = point.getX(); // reassign minX
            }
            if (point.getY() > maxY) { //check if point is less than min required
                maxY = point.getY(); // reassign minX
            }


            Point bottomLeft = new Point(minX,maxY);
            Point topRight = new Point(maxX,minY);

            /* invoke new BB and assign to object with new co-ords*/
            this.boundingBox = new BoundingBox(bottomLeft,topRight);

        }

    }




    /*looping over center points to devrive BB points
    * (x1, y2) = smallest x & largest y
    * (x2,y2) = largest x & largest y*/

//    public Quadrilateral(Point centerPoint, Point[] points) {}
//

//
//    public Quadrilateral(Rectangle rectangle) {}

    @Override
    public void drawShape(Graphics g) {
        /* You should use the Graphics object’s drawPolygon() and fillPolygon() methods to render the quad. */

        System.out.println(this.toString()); // the 'shapes' object - class 3-  1hr04m (just console)
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(1));

        /* new Polygon Obj and loop over Quad/Polygon points */

        Polygon polygon = new Polygon();
        for (Point point: points) {
            polygon.addPoint(point.getX(), point.getY());
        }

        /* check if filled, invoke draw method depending on bool*/

        if (filled) {
            g.fillPolygon(polygon);
        }

        else {
            g.drawPolygon(polygon);
        }


    }

    /* Override ToString for Debugging purposes (console)- 1/11/22 */
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "color=" + color +
                ", filled=" + filled +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }


    @Override
    public void rotateNinetyDegrees(int angleDegrees) {
        /* rotating quad obj upon click */
    }
}
