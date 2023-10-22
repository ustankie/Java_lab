package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
public class OptionParser {
    public static MoveDirection[] parse(String[]args){
        int i=0;
        for(String arg : args){
            if(arg.equals("f") || arg.equals("b") || arg.equals("r")||arg.equals("l")){
                i+=1;
            }

        }
        MoveDirection[] parsed=new MoveDirection[i];

        int j=0;
        for(String arg : args){
            switch(arg){
                case "f"->parsed[j]=MoveDirection.FORWARD;
                case "b"->parsed[j]=MoveDirection.BACKWARD;
                case "r"->parsed[j]=MoveDirection.RIGHT;
                case "l"->parsed[j]=MoveDirection.LEFT;
                default -> j-=1;
            }

            j+=1;
        }
        return parsed;
    }
}
