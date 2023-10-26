package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MapDirectionTest {

    @Test
    public void nextTest(){
//        given
        MapDirection west=MapDirection.WEST;
        MapDirection east= MapDirection.EAST;
        MapDirection south=MapDirection.SOUTH;
        MapDirection north=MapDirection.NORTH;

//        when
        MapDirection westNext=west.next();
        MapDirection eastNext=east.next();
        MapDirection southNext=south.next();
        MapDirection northNext=north.next();

//        then
        Assertions.assertEquals(westNext,MapDirection.NORTH);
        Assertions.assertEquals(eastNext,MapDirection.SOUTH);
        Assertions.assertEquals(southNext,MapDirection.WEST);
        Assertions.assertEquals(northNext,MapDirection.EAST);

    }


    @Test
    public void previousTest(){
//        given
        MapDirection west=MapDirection.WEST;
        MapDirection east= MapDirection.EAST;
        MapDirection south=MapDirection.SOUTH;
        MapDirection north=MapDirection.NORTH;

//        when
        MapDirection westPrevious=west.previous();
        MapDirection eastPrevious=east.previous();
        MapDirection southPrevious=south.previous();
        MapDirection northPrevious=north.previous();

//        then
        Assertions.assertEquals(westPrevious,MapDirection.SOUTH);
        Assertions.assertEquals(eastPrevious,MapDirection.NORTH);
        Assertions.assertEquals(southPrevious,MapDirection.EAST);
        Assertions.assertEquals(northPrevious,MapDirection.WEST);

    }



}
