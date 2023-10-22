package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2DTest {
    @Test
    public void equalsTest(){
//        given
        Vector2D v1=new Vector2D(1,2);
        Vector2D v2=new Vector2D(1,2);
        Vector2D v3=new Vector2D(1,3);
        Vector2D v4=new Vector2D(2,-7);

//        then
        Assertions.assertTrue(v1.equals(v2));
        Assertions.assertFalse(v1.equals(v3));
        Assertions.assertFalse(v4.equals(v3));

    }


    @Test
    public void toStringTest(){
//        given
        Vector2D v1=new Vector2D(1,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);

//        when
        String s1="(1,2)";
        String s2="(1,3)";
        String s3="(2,-7)";
//        then
        Assertions.assertEquals(v1.toString(),s1);
        Assertions.assertEquals(v2.toString(),s2);
        Assertions.assertEquals(v3.toString(),s3);
    }

    @Test
    public void precedesTest(){
//        given
        Vector2D v1=new Vector2D(1,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);

//        then
        Assertions.assertFalse(v1.precedes(v3));
        Assertions.assertTrue(v1.precedes(v2));

    }

    @Test
    public void followsTest(){
        //        given
        Vector2D v1=new Vector2D(1,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);

//        then
        Assertions.assertFalse(v3.follows(v2));
        Assertions.assertTrue(v2.follows(v1));
    }

    @Test
    public void upperRightTest(){

        Vector2D v1=new Vector2D(1,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);


        Vector2D v1v2=new Vector2D(1,3);
        Vector2D v1v3=new Vector2D(2,2);

        Assertions.assertEquals(v1v2,v1.upperRight(v2));
        Assertions.assertEquals(v1v3,v3.upperRight(v1));

    }

    @Test
    public void lowerLeftTest(){
        Vector2D v1=new Vector2D(-2,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);


        Vector2D v1v2=new Vector2D(-2,2);
        Vector2D v1v3=new Vector2D(-2,-7);

        Assertions.assertEquals(v1v2,v1.lowerLeft(v2));
        Assertions.assertEquals(v1v3,v3.lowerLeft(v1));
    }

    @Test
    public void addTest(){
        Vector2D v1=new Vector2D(-2,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);

        Assertions.assertEquals(v1.add(v2).getX(),-1);
        Assertions.assertEquals(v1.add(v2).getY(),5);
        Assertions.assertEquals(v1.add(v3).getX(),0);
        Assertions.assertEquals(v1.add(v3).getY(),-5);
    }

    @Test
    public void substractTest(){
        Vector2D v1=new Vector2D(-2,2);
        Vector2D v2=new Vector2D(1,3);
        Vector2D v3=new Vector2D(2,-7);

        Assertions.assertEquals(v1.substract(v2).getX(),-3);
        Assertions.assertEquals(v1.substract(v2).getY(),-1);
        Assertions.assertEquals(v1.substract(v3).getX(),-4);
        Assertions.assertEquals(v1.substract(v3).getY(),9);
    }

    @Test
    public void oppositeTest(){
        Vector2D v1=new Vector2D(-2,2);
        Vector2D v2=new Vector2D(1,0);
        Vector2D v3=v1.opposite();
        Vector2D v4=v2.opposite();

        Assertions.assertEquals(v3.getX(),2);
        Assertions.assertEquals(v3.getY(),-2);
        Assertions.assertEquals(v4.getX(),-1);
        Assertions.assertEquals(v4.getY(),0);
    }

}


