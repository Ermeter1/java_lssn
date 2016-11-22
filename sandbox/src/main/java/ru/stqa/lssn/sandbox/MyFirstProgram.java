package ru.stqa.lssn.sandbox;


import org.omg.CORBA.PUBLIC_MEMBER;

public class MyFirstProgram {

    public static void main(String[] args) {

        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);

        //System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + distance);
        p1.distancePrint(p1,p2);

        p1.x = 1;
        p1.y = 1;
        p2.x = 10;
        p2.y = 1;

        //System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p1.distance(p1,p2));
        p1.distancePrint(p1,p2);

        p1.x = 100;
        p1.y = 1;
        p2.x = 10;
        p2.y = 1;

        //System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p1.distance(p1,p2));
        p1.distancePrint(p1,p2);

        p1.x = 100;
        p1.y = 100;
        p2.x = 1;
        p2.y = 1;

        p1.distancePrint(p1,p2);
        p1.distancePrint(p1,p1);
        p1.distancePrint(p2,p2);
        p2.distancePrint(p1,p2);
        p2.distancePrint(p2,p1);
    }

//    public static void distancePrint(Point p1, Point p2){
//        System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p1.distance(p1,p2));
//    }

}