package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
public class OptionParser {
    public static MoveDirection[] parse(String[]args){
        MoveDirection[] parsed=new MoveDirection[args.length];
        int i=0;
        for(String arg : args){
            switch(arg){
                case "f"->parsed[i]=MoveDirection.FORWARD;
                case "b"->parsed[i]=MoveDirection.BACKWARD;
                case "r"->parsed[i]=MoveDirection.RIGHT;
                case "l"->parsed[i]=MoveDirection.LEFT;
            }
            i+=1;
        }
        return parsed;
    }
}
