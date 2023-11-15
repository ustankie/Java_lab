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
        String[] args= {"f", "f", "b", "l", "r"};
        List<MoveDirection> solved= Arrays.asList(MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT);

        Assertions.assertEquals(solved, OptionParser.parse(args));
    }

    @Test
    public void illegalArgumentExceptionTest(){
        String[] args={"f", "b", "rb",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};


        Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OptionParser.parse(args);
        });

        Assertions.assertEquals(thrown.getMessage(),"rb is not legal move specification");


    }

}
