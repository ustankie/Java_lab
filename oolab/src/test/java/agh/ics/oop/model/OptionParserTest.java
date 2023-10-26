package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionParserTest {

    @Test
    public void parseTest(){
        String[] args= {"f", "f", "g", "b", "k","l", "r", "fg"};
        List<MoveDirection> solved= Arrays.asList(MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT);

        Assertions.assertEquals(solved, OptionParser.parse(args));
    }
}
