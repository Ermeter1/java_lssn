package ru.stqa.lssn.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    Point p1 = new Point(1,1);
    Point p2 = new Point(1,2);

    @Test
    public void testDistance1(){
        Assert.assertEquals(p2.distance(p1), 1.0);
    }

    @Test
    public void testDistance9(){
        p1.x = 1;
        p1.y = 1;
        p2.x = 10;
        p2.y = 1;

        Assert.assertEquals(p2.distance(p1), 9.0);
    }

    @Test
    public void testDistance90(){
        p1.x = 100;
        p1.y = 1;
        p2.x = 10;
        p2.y = 1;

        Assert.assertEquals(p2.distance(p1), 90.0);
    }

    @Test
    public void testDistance140(){
        p1.x = 100;
        p1.y = 100;
        p2.x = 1;
        p2.y = 1;

        Assert.assertEquals(p2.distance(p1), 140.0071426749364);
    }

}
