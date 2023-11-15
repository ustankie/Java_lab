package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ExceptionTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    public void simulationTest(){
        String[] args={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        GrassField map=new GrassField(10);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);

        Simulation simulation=new Simulation(moveDirectionList,positions,map);
        simulation.run();

        Assertions.assertEquals("Position (3,4) is already occupied\n" +
                        "Position (2,4) is already occupied\n" +
                        "Position (3,4) is already occupied\n" +
                        "Position (4,4) is already occupied",
                outputStreamCaptor.toString()
                        .trim());

        String[] args1={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        RectangularMap map1=new RectangularMap(3,5);
        List<Vector2D> positions1= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList1= OptionParser.parse(args1);

        Simulation simulation1=new Simulation(moveDirectionList1,positions1,map1);
        simulation1.run();

        Assertions.assertEquals("Position (3,4) is already occupied\n" +
                        "Position (2,4) is already occupied\n" +
                        "Position (3,4) is already occupied\n" +
                        "Position (4,4) is already occupied\n" +
                        "Position (3,4) is already occupied\n" +
                        "Position (2,4) is already occupied\n" +
                        "Position (4,4) is not in map\n" +
                        "Position (3,4) is already occupied\n" +
                        "Position (2,4) is already occupied\n" +
                        "Position (3,4) is already occupied",
                outputStreamCaptor.toString()
                        .trim());

    }

    @Test
    public void placeRectangularMapTest(){
        RectangularMap map=new RectangularMap(7,8);
        Animal animal1=new Animal(new Vector2D(2,3));
        Animal animal2=new Animal(new Vector2D(-1,9));
        Animal animal3=new Animal(new Vector2D(7,8));
        Animal animal3a=new Animal(new Vector2D(7,8));

        boolean res1=map.place(animal1);
        boolean res2=map.place(animal2);
        boolean res3=map.place(animal3);
        boolean res3a=map.place(animal3a);

        RectangularMap map1=new RectangularMap(3,2);
        Animal animal4=new Animal(new Vector2D(2,2));
        Animal animal5=new Animal(new Vector2D(-1,9));
        Animal animal6=new Animal(new Vector2D(1,0));

        boolean res4=map1.place(animal4);
        boolean res5=map1.place(animal5);
        boolean res6=map1.place(animal6);

        Assertions.assertEquals("Position (-1,9) is not in map\n" +
                        "Position (7,8) is already occupied\n" +
                        "Position (-1,9) is not in map",
                outputStreamCaptor.toString()
                        .trim());
    }

    @Test
    public void placeGrassFieldTest(){
        GrassField grassField=new GrassField(10);
        Animal animal=new Animal(new Vector2D(2,2));
        Grass grass=new Grass(new Vector2D(2,2));
        Animal animal1=new Animal(new Vector2D(-1,100));
        Animal animal2=new Animal(new Vector2D(-1,100));
        Grass grass1=new Grass(new Vector2D(0,0));
        Animal animal3=new Animal(new Vector2D(0,0));

        grassField.place(animal);
        grassField.place(grass);
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(grass1);
        grassField.place(animal3);

        Assertions.assertEquals(
                        "Position (2,2) is already occupied\n" +
                        "Position (-1,100) is already occupied",
                outputStreamCaptor.toString()
                        .trim());
    }

    @Test
    public void grassFieldMoveTest() {
        Animal animal1 = new Animal(new Vector2D(1, 2));
        Animal animal2 = new Animal(new Vector2D(1, 3));

        GrassField grassField = new GrassField(15);
        grassField.place(animal1);
        grassField.place(animal2);

        grassField.move(animal1, MoveDirection.LEFT);
        grassField.move(animal2, MoveDirection.LEFT);
        grassField.move(animal2, MoveDirection.LEFT);
        grassField.move(animal2, MoveDirection.FORWARD); //tu animal2 próbuje wejść na pozycję zajmowaną przez animal1 - mapa na to nie pozwala

        grassField.move(animal1, MoveDirection.FORWARD);
        grassField.move(animal1, MoveDirection.LEFT);
        grassField.move(animal1, MoveDirection.FORWARD);
        grassField.move(animal2, MoveDirection.BACKWARD);

        grassField.place(new Grass(new Vector2D(1, 2)));
        grassField.move(animal1, MoveDirection.LEFT);
        grassField.move(animal2, MoveDirection.LEFT);

        grassField.move(animal1, MoveDirection.FORWARD);
        grassField.move(animal1, MoveDirection.LEFT);
        grassField.move(animal1, MoveDirection.FORWARD); //animal1 wchodzi na trawę
        grassField.move(animal2, MoveDirection.LEFT);
        grassField.move(animal2, MoveDirection.BACKWARD);
        grassField.move(animal2, MoveDirection.BACKWARD);

        Assertions.assertEquals(
                "Position (1,2) is already occupied\n" +
                        "Position (1,2) is already occupied",
                outputStreamCaptor.toString()
                        .trim());
    }

    @Test
    public void rectangularMapMoveTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        RectangularMap map=new RectangularMap(3,4);
        map.place(animal1);
        map.place(animal2);


        map.move(animal2,MoveDirection.LEFT);
        map.move(animal2,MoveDirection.LEFT);
        map.move(animal2,MoveDirection.FORWARD); //tu animal2 próbuje wejść na pozycję zajmowaną przez animal1 - mapa na to nie pozwala

        map.move(animal1,MoveDirection.LEFT);
        map.move(animal1,MoveDirection.LEFT);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.LEFT);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal2,MoveDirection.BACKWARD);



        map.move(animal2,MoveDirection.LEFT);

        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal1,MoveDirection.LEFT);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal2,MoveDirection.BACKWARD);


        Assertions.assertEquals(
                "Position (1,2) is already occupied\n" +
                        "Position (1,-1) is not in map\n"+
                        "Position (4,0) is not in map\n"+
                        "Position (4,0) is not in map\n"+
                        "Position (4,0) is not in map",
                outputStreamCaptor.toString()
                        .trim());
    }
}
