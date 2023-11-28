//package agh.ics.oop.model;
//
//import agh.ics.oop.OptionParser;
//import agh.ics.oop.Simulation;
//import agh.ics.oop.SimulationTextMap;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class SimulationTextMapIT {
//
//    @Test
//    public void dataInterpretationTest(){
//        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
//        TextMap map=new TextMap();
//        List<String> strings=List.of("Ala","Ela","Ola","ma","kota");
//        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
//        SimulationTextMap simulation=new SimulationTextMap(moveDirectionList,strings,map);
//
//
//        Assertions.assertNotNull(simulation.getStrings());
//        Assertions.assertTrue(simulation.getStrings() instanceof List<String>);
//
//        Assertions.assertNotNull(simulation.getMoveDirectionList());
//        Assertions.assertTrue(simulation.getMoveDirectionList() instanceof List<MoveDirection>);
//
//
//        Assertions.assertEquals(strings.size(),simulation.getStrings().size());
//        Assertions.assertEquals(strings,simulation.getStrings());
//
//        Assertions.assertEquals(moveDirectionList,simulation.getMoveDirectionList());
//    }
//    @Test
//    public void positionTest(){
//        String[] args={"r", "b", "r","l", "f",
//                "f", "r", "r", "f", "f",
//                "f", "f", "f", "f", "f",
//                "f"};
//        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
//
//        List<String> strings=List.of("Ala","Ela","Ola","ma","kota");
//
//        TextMap map=new TextMap();
//
//        SimulationTextMap simulation=new SimulationTextMap(moveDirectionList,strings,map);
//        simulation.run();
//
//        List<String> stringsRes=List.of("ma","Ela","Ola","Ala","kota");
//        Assertions.assertEquals(map.getStringsOnMap(),stringsRes);
//
//        String[] args1={"r", "b", "r",
//                "l", "f", "f",
//                "r", "r", "f",
//                "f", "f", "f",
//                "f", "f", "f",
//                "f"};
//
//        List<MoveDirection> moveDirectionList1= OptionParser.parse(args1);
//
//        List<String> strings1=List.of("Ala","Ela","Ola");
//
//        TextMap map1=new TextMap();
//
//        SimulationTextMap simulation1=new SimulationTextMap(moveDirectionList1,strings1,map1);
//        simulation1.run();
//
//        List<String> stringsRes1=List.of("Ela","Ala","Ola");
//        Assertions.assertEquals(map1.getStringsOnMap(),stringsRes1);
//
//    }
//
//    @Test
//    public void orientationTest(){
//        String[] args={"r", "b", "r","l", "f",
//                "f", "r", "r", "f", "f",
//                "f", "f", "f", "f", "f",
//                "f"};
//        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
//
//        List<String> strings=List.of("Ala","Ela","Ola","ma","kota");
//
//        TextMap map=new TextMap();
//
//        SimulationTextMap simulation=new SimulationTextMap(moveDirectionList,strings,map);
//        simulation.run();
//
//        Assertions.assertEquals(map.getDirections().get("Ala"),MapDirection.EAST);
//        Assertions.assertEquals(map.getDirections().get("Ela"),MapDirection.EAST);
//        Assertions.assertEquals(map.getDirections().get("Ola"),MapDirection.SOUTH);
//        Assertions.assertEquals(map.getDirections().get("ma"),MapDirection.WEST);
//        Assertions.assertEquals(map.getDirections().get("kota"),MapDirection.NORTH);
//
//        String[] args1={"r", "b", "r",
//                "l", "f", "f",
//                "r", "r", "f",
//                "f", "f", "f",
//                "f", "f", "f",
//                "f"};
//
//        List<MoveDirection> moveDirectionList1= OptionParser.parse(args1);
//
//        List<String> strings1=List.of("Ala","Ela","Ola");
//
//        TextMap map1=new TextMap();
//
//        SimulationTextMap simulation1=new SimulationTextMap(moveDirectionList1,strings1,map1);
//        simulation1.run();
//
//        List<String> stringsRes1=List.of("Ela","Ala","Ola");
//        Assertions.assertEquals(map1.getDirections().get("Ala"),MapDirection.EAST);
//        Assertions.assertEquals(map1.getDirections().get("Ela"),MapDirection.EAST);
//        Assertions.assertEquals(map1.getDirections().get("Ola"),MapDirection.EAST);
//    }
//}
