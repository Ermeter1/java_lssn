package ru.stqa.lssn.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by ivan on 26.11.2016.
 */
public class SquareTests {

    @Test
    public void testArea(){
        Square s = new Square(5);
        //assert s.area()==24;
        Assert.assertEquals(s.area(), 25.0);
        
    }
}
