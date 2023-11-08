package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.TextMap;
import agh.ics.oop.model.WorldMap;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SimulationTextMap {
    private List<String> strings;;
    private List<MoveDirection> moveDirectionList;
    private WorldMap<String, Integer> map;
    public SimulationTextMap(List<MoveDirection> moveDirectionList, List<String> strings, WorldMap<String,Integer> map){
        this.map=map;

        int l=strings.size();
        this.strings =new ArrayList<String>();


        for (String str: strings) {
            if (str!=null && this.map.place(str))
                this.strings.add(str);
        }

        this.moveDirectionList=new ArrayList<MoveDirection>(moveDirectionList);
    }

    public List<String> getStrings(){
        return strings;
    }

    public List<MoveDirection> getMoveDirectionList(){
        return moveDirectionList;
    }

    public WorldMap<String,Integer> getMap() {
        return map;
    }

    public void run(){
        int currStrInd=0;
        int stringsLength= strings.size();

        String currString;


        for(MoveDirection direction: moveDirectionList){
            currString= strings.get(currStrInd);
            TextMap map1=(TextMap) map;
            map.move(currString,direction);


            currStrInd=(currStrInd+1)%stringsLength;
        }
    }
}
