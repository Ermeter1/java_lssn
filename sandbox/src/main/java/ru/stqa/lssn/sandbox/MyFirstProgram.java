package ru.stqa.lssn.sandbox;


import org.omg.CORBA.PUBLIC_MEMBER;

public class MyFirstProgram {

    public static void main(String[] args) {

        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);

        System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p2.distance(p1));

        p1.x = 1;
        p1.y = 1;
        p2.x = 10;
        p2.y = 1;

        System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p2.distance(p1));

        p1.x = 100;
        p1.y = 1;
        p2.x = 10;
        p2.y = 1;

        System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p2.distance(p1));

        p1.x = 100;
        p1.y = 100;
        p2.x = 1;
        p2.y = 1;

        System.out.println("Расстояние между точкой (x,y) " + p1.x + "," + p1.y + " и точкой (x,y) " + p2.x + "," + p2.y + " составляет " + p2.distance(p1));

    }


}