//package agh.ics.oop.model;
//
//import java.util.*;
//
//public class TextMap implements WorldMap<String,Integer> {
//
//    private Map<String,MapDirection> directions =new HashMap<>();
//    private Map<String,Integer> positions =new HashMap<>();
//    private List<String> stringsOnMap = new ArrayList<>();
//    private int height=0;
//
//    public int getHeight() {
//        return height;
//    }
//
//    public Map<String, MapDirection> getDirections() {
//        return directions;
//    }
//
//    public Map<String, Integer> getPositions() {
//        return positions;
//    }
//
//    public List<String> getStringsOnMap() {
//        return stringsOnMap;
//    }
//
//    public boolean isOnMap(String str){
//        for (String el : stringsOnMap) {
//            if(el.equals(str)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void swap(String str,int step){
//
//        String temp=objectAt(positions.get(str)+step);
//        int tempPos=positions.get(temp);
//        positions.replace(temp,positions.get(str));
//        stringsOnMap.set(positions.get(str),temp);
//        stringsOnMap.set(tempPos,str);
//        positions.replace(str,tempPos);
//
//    }
//    public void setDirection(String str,MapDirection direction){
//        directions.replace(str,direction);
//    }
//
//
//    public void setPosition(String str,int moveDir){
//        if(directions.get(str)==MapDirection.NORTH || directions.get(str)==MapDirection.SOUTH)
//            return;
//
//        if(directions.get(str)==MapDirection.WEST){
//            if(canMoveTo(positions.get(str)+(-1)*moveDir)){
//                swap(str,(-1)*moveDir);
//            }
//        }else{
//            if(canMoveTo(positions.get(str)+moveDir)){
//                swap(str,moveDir);
//            }
//        }
//    }
//
//    @Override
//    public boolean place(String str) {
//        if(!isOnMap(str)){
//            stringsOnMap.add(str);
//            directions.put(str,MapDirection.NORTH);
//            positions.put(str,height);
//            height++;
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void move(String str, MoveDirection direction) {
//        if(!isOnMap(str))
//            return;
//        switch(direction){
//            case LEFT -> setDirection(str, directions.get(str).previous());
//            case RIGHT -> setDirection(str, directions.get(str).next());
//            case BACKWARD -> setPosition(str,-1);
//            case FORWARD -> setPosition(str,1);
//        }
//    }
//
//    @Override
//    public boolean isOccupied(Integer position) {
//        return stringsOnMap.get(position)!=null;
//    }
//
//    @Override
//    public String objectAt(Integer position) {
//        return stringsOnMap.get(position);
//    }
//
//
//    @Override
//    public boolean canMoveTo(Object position1) {
//        Integer position=(Integer)position1;
//        return position >= 0 && position < height;
//    }
//
//    @Override
//    public String toString() {
//        return stringsOnMap.toString();
//    }
//
//    @Override
//    public List<String> getElements() {
//        return getStringsOnMap();
//    }
//}
