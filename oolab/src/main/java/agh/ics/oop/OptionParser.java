package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionParser {
    public static List<MoveDirection> parse(String[]args){
        List<MoveDirection> parsed=new ArrayList<MoveDirection>();

        for(String arg : args){

            switch(arg){
                case "f"->parsed.add(MoveDirection.FORWARD);
                case "b"->parsed.add(MoveDirection.BACKWARD);
                case "r"->parsed.add(MoveDirection.RIGHT);
                case "l"->parsed.add(MoveDirection.LEFT);
                default->throw new IllegalArgumentException(arg+" is not legal move specification");
            }

        }
        return parsed;
    }
}

