//package agh.ics.oop.model;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.w3c.dom.Text;
//
//import java.util.List;
//
//public class TextMapTest {
//
//    @Test
//    public void placeTest(){
//        String s1="Ala";
//        String s2="Ola";
//        String s3="Pola";
//        String s4="ma";
//        String s5="kota";
//
//        TextMap map=new TextMap();
//
//        map.place(s1);
//        map.place(s2);
//        map.place(s3);
//        map.place(s4);
//        map.place(s5);
//
//        List<String> strings= List.of(s1,s2,s3,s4,s5);
//
//
//        Assertions.assertEquals(strings,map.getStringsOnMap());
//    }
//    @Test
//
//    public void uniqueTest(){
//        String s1="Ala";
//        String s2="Ola";
//        String s3="Pola";
//        String s4="ma";
//        String s5="kota";
//        String s6="kota";
//
//        TextMap map=new TextMap();
//
//        map.place(s1);
//        map.place(s2);
//        map.place(s3);
//        map.place(s4);
//        map.place(s5);
//        map.place(s5);
//        map.place(s6);
//
//        List<String> strings= List.of(s1,s2,s3,s4,s5);
//
//
//        Assertions.assertEquals(strings,map.getStringsOnMap());
//    }
//
//    @Test
//    public void moveTest(){
//        String s1="Ala";
//        String s2="Ola";
//        String s3="Pola";
//        String s4="ma";
//        String s5="kota";
//
//        TextMap map=new TextMap();
//
//        map.place(s1);
//        map.place(s2);
//        map.place(s3);
//        map.place(s4);
//        map.place(s5);
//
//        map.move(s1,MoveDirection.BACKWARD);
//        map.move(s2,MoveDirection.LEFT);
//
//
//        List<String> strings= List.of(s1,s2,s3,s4,s5);
//        Assertions.assertEquals(strings,map.getStringsOnMap());
//
//        map.move(s2,MoveDirection.BACKWARD);
//        map.move(s5,MoveDirection.RIGHT);
//        map.move(s5,MoveDirection.BACKWARD);
//        map.move(s4,MoveDirection.BACKWARD);
//
//        strings=List.of(s1,s3,s2,s5,s4);
//        Assertions.assertEquals(strings,map.getStringsOnMap());
//
//        map.move(s2,MoveDirection.BACKWARD);
//        map.move(s2,MoveDirection.BACKWARD);
//        map.move(s5,MoveDirection.BACKWARD);
//        map.move(s1,MoveDirection.RIGHT);
//
//        strings=List.of(s1,s5,s3,s4,s2);
//        Assertions.assertEquals(strings,map.getStringsOnMap());
//
//    }
//
//    @Test
//    public void inMapTest(){
//        String s1="Ala";
//        String s2="Ola";
//        String s3="Pola";
//        String s4="ma";
//        String s5="kota";
//
//        TextMap map=new TextMap();
//
//        map.place(s1);
//        map.place(s2);
//        map.place(s3);
//        map.place(s4);
//        map.place(s5);
//
//
//
//        map.move(s2,MoveDirection.BACKWARD);
//        map.move(s2,MoveDirection.BACKWARD);
//        map.move(s5,MoveDirection.BACKWARD);
//        map.move(s1,MoveDirection.RIGHT);
//        map.move(s3,MoveDirection.FORWARD);
//        map.move(s2,MoveDirection.RIGHT);
//        map.move(s5,MoveDirection.LEFT);
//        map.move(s4,MoveDirection.RIGHT);
//        map.move(s2,MoveDirection.FORWARD);
//        map.move(s5,MoveDirection.RIGHT);
//        map.move(s1,MoveDirection.LEFT);
//        map.move(s2,MoveDirection.RIGHT);
//
//
//        Assertions.assertTrue(map.getStringsOnMap().size()==5);
//
//        for(int i=0;i<5;i++){
//            Assertions.assertTrue(map.getPositions().get(map.getStringsOnMap().get(i))>=0
//                    &&map.getPositions().get(map.getStringsOnMap().get(i))<map.getHeight());
//        }
//
//    }
//
//
//}
