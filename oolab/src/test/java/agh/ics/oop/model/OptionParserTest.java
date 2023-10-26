package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionParserTest {

    @Test
    public void parseTest(){
        String[] args= {"f", "f", "g", "b", "l", "r", "fg"};
        MoveDirection[] solved={MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT};

        Assertions.assertArrayEquals(solved, OptionParser.parse(args));
    }
}
