package com.ca1files;

/* implements rotatable interface */

import java.awt.*;
import java.util.ArrayList;

/* inherits from Shape can get a Center point
* we will use to implement rotation(), so Quad class
* also implements Rotatable Interface */
public class Quadrilateral extends Shape implements Rotatable {

    /* set point Array list to len 4 */
    private Point[] points = new Point[4];

    /* Center point to recalibrate the qud(rect) bounding box */
    private Point centerPoint;


    /* this constructor we pass in an arrayList to loop over and assign points depending on conditions
    * --> public Quadrilateral(Point centerPoint, Point[] points) {} etc. */
    public Quadrilateral(Color color, boolean filled,  Point centerPoint, Point[] pointsList) {
        super(color, filled, centerPoint.getX(), centerPoint.getY());
        this.centerPoint = centerPoint;

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
        /* checking the point tuples via prints to console - commented out  */
//        System.out.println("bottomLeftPoint = " + bottomLeftPoint);
//        System.out.println("topRightPoint = " + topRightPoint);
//        System.out.println("bottomRightPoint = " + bottomRightPoint);
//        System.out.println("topLeftPoint = " + topLeftPoint); //

        /* assigning derived point to this.object vars to list (via index) */
        this.points[0] = topLeftPoint;
        this.points[1] = topRightPoint;
        this.points[2] = bottomRightPoint;
        this.points[3] = bottomLeftPoint;

        /* Invoked new Bounding Box method here */
        setQuadBoundingBox(this.points);

    }

    /* Constructor for Quad specific 4 points - centerPoint(x,y) - extracted via getters */
    public Quadrilateral(Color color, boolean filled, Point centerPoint, Point point1, Point point2, Point point3, Point point4) {
        super(color, filled, centerPoint.getX(), centerPoint.getY());
        this.centerPoint = centerPoint;

        /* vars for 4 points of quad */
        Point topLeftPoint = new Point();
        Point topRightPoint = new Point();
        Point bottomLeftPoint = new Point();
        Point bottomRightPoint = new Point();

        /* old line - unused and commented */
//        this.points.add(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);

        /* assigning 4 points to a vertexList */
        Point[] vertexList = {point1, point2, point3, point4};

        /* quick loop to check vertex */
//        for (Point vertex: vertexList) {
//            System.out.println("these are the vertex: "+ vertex);
//
//        }
        /* assigning vertexList vars via index e.g. topLeft point = (x: 300, y: 200) */
        topLeftPoint = vertexList[0];
        topRightPoint = vertexList[1];
        bottomLeftPoint = vertexList[2];
        bottomRightPoint = vertexList[3];

        /* assign to points to be used to build BB */
        this.points[0] = topLeftPoint;
        this.points[1] = topRightPoint;
        this.points[2] = bottomLeftPoint;
        this.points[3] = bottomRightPoint;

        /* Invoked new Bounding Box method here */
        setQuadBoundingBox(this.points);

    }

    /* looping over center points to derive BB points
     * (x1, y2) = smallest x & largest y
     * (x2,y2) = largest x & largest y */
    private void setQuadBoundingBox(Point[] points) {
        /* here we find the mix-max for (x,y) co-ords so we can set the BB*/
        int minX = points[0].getX(); // getter for X min
        int maxX = points[1].getX();
        int minY = points[2].getY();
        int maxY = points[3].getY();

        /* loop over points list and assign points based on derived bounds */

        for (Point point: points) {

            if (point.getX() < minX) { //check if point is less than minX required
                minX = point.getX(); // reassign minX
            }
            if (point.getY() < minY) { //check if point is less than minY required
                minY = point.getY(); // reassign minY
            }

            if (point.getX() > maxX) { //check if point is greater than maxX required
                maxX = point.getX(); // reassign maxX
            }
            if (point.getY() > maxY) { //check if point is greater than maxY required
                maxY = point.getY(); // reassign maxY
            }

            /* assigning new points to 2 Point values for BB */
            Point bottomLeft = new Point(minX,maxY);
            Point topRight = new Point(maxX,minY);

            /* invoke new BB and assign to object with new co-ords*
            * like a Rect around quad*/
            this.boundingBox = new BoundingBox(bottomLeft,topRight);

        }

    }

    /* constructor/ method to create a polygon/quad using a Rect obj class */
    public Quadrilateral(Color color, boolean filled, Rectangle rectangle) {
        super(color, filled, rectangle.xCenter, rectangle.yCenter); //rectangle.height, rectangle.width - just 4 in constructor
        /* accessing attributes/co-ords etc. via inheritance */
        int quadX = rectangle.xCenter;
        int quadY = rectangle.yCenter;
        int quadWidth = rectangle.width;
        int quadHeight = rectangle.height;


        /* unused and commented out code - errors that were resolved */
//        this.centerPoint = rectangle.getRectCenterPoint();
//        Point rectCenter = new Point(rectangle.xCenter, rectangle.yCenter);
//        this.centerPoint = rectCenter;
        /* getting the center of the rect for the rotation */
//        if (rightClick()) {
//            Point rCenter2 = new Point(rectangle.xCenter, rectangle.yCenter);
//            this.centerPoint = rCenter2;
//        }

        /* calculate x,y co-ords to derive quad vertex using center x&y points
        * width along X-axis, height along Y-axis */

        this.points[0] = new Point((quadX - quadWidth), (quadY - quadHeight)); // (x,y) bottom right
        this.points[1] = new Point((quadX + quadWidth), (quadY - quadHeight)); // (x,y) top right
        this.points[2] = new Point((quadX + quadWidth), (quadY + quadHeight)); // (x,y) top left
        this.points[3] = new Point((quadX - quadWidth), (quadY + quadHeight)); // (x,y) bottom left


        /* assign this.centerpoint to rect's derived center */
        this.centerPoint = rectangle.getRectCenterPoint();

        /* Invoked new Bounding Box (for Polygon via Rect) method here */
        setQuadBoundingBox(this.points);
        /* unused and commented out code - errors that were resolved */
//        System.out.println("this is the rectangle (quads) center point: " + centerPoint);
//        this.boundingBox = new BoundingBox(this.points[3], this.points[1]);


    }


    /* override draw shapes method to fill or draw Polygon via enhanced for loop */
    @Override
    public void drawShape(Graphics g) {
        /* You should use the Graphics object’s drawPolygon() and fillPolygon() methods to render the quad. */

//        System.out.println(this.toString()); // the 'shapes' object - class 3-  1hr04m (just console)
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

    /* check if rightClick clicked & invoke rotate method */
    @Override
    public boolean rightClick() {
        rotateNinetyDegrees();
        return true;
    }

    /* override Rotate method and trigonometry calculations to correctly invoke
    *  rotate method and rotate shape by 90degrees (center point as origin) */
    @Override
    public void rotateNinetyDegrees() {

        /* rotating quad obj upon click
        * assign angle var to 90 degs via Consts file */
        int angle = Consts.ROTATION_ANGLE;

        /* via Dermot - 'Java methods accept the angle as a parameter in Radians!'
        * so we invoke .toRadians method below */
        float radians = (float) Math.toRadians(angle); //
        System.out.println(radians); // 90 degree == 1.57 radians
//        System.out.println(Math.toRadians());
        float cosTheta = (float) Math.cos(radians); // -4.37..
        float sinTheta = (float) Math.sin(radians); // 1.0

        /* check CosSine & sine output */
        System.out.println("CosSine == " + cosTheta);
        System.out.println("sinTheta == " + sinTheta);


        /* loop over points (x,y) and derive new points via formula (Theta = 0)
        * x` = Xcos0 - Ysin0 & y` = Xsin0 + Ycos0
        * New X value: CenterX + (diff between X points) * cos0 - (dif between y points) * sin0 */
        for (Point point: points) {
            int xCenterDifference = point.getX() - centerPoint.getX() ;
            int yCenterDifference = point.getY() - centerPoint.getY();
            float newX = centerPoint.getX() + xCenterDifference * cosTheta - yCenterDifference * sinTheta; //BEMDAS
            float newY = centerPoint.getY() + xCenterDifference * sinTheta + yCenterDifference * cosTheta;

            int x = Math.round(newX);
            int y = Math.round(newY);

            point.setX(x);
            point.setY(y);

            /* unused setter which truncates the float -> int*/
//            point.setX((int) newX); // reset float to int change type (truncate)
//            point.setY((int) newY);


        }



    }

}
