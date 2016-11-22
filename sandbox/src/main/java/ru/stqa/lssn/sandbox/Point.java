package ru.stqa.lssn.sandbox;

/**
 * Created by Ivan on 22.11.2016.
 */
public class Point {

    public int x;
    public int y;

    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

//    public double distance(Point p1, Point p2){
//        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+ (p2.y-p1.y)*(p2.y-p1.y));
//    }

    public void distancePrint(Point p1, Point p2){
        Double distance = Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+ (p2.y-p1.y)*(p2.y-p1.y));
        System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + distance);
    }


}
