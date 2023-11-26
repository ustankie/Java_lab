package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorldMapTest {
    @Test
    public void getElementsRectangularMapTest(){
        RectangularMap map=new RectangularMap(7,8);
        Animal animal1=new Animal(new Vector2D(2,3));
        Animal animal2=new Animal(new Vector2D(-1,9));
        Animal animal3=new Animal(new Vector2D(7,8));

        Assertions.assertDoesNotThrow(()->{
            map.place(animal1);

        });
        Assertions.assertThrows(PositionAlreadyOccupiedException.class,()->{
            map.place(animal2);
        });


        Assertions.assertDoesNotThrow(()->{
            map.place(animal3);

        });


        List<WorldElement> elements=List.of(new Animal(new Vector2D(2,3)),
                new Animal(new Vector2D(7,8)));
        Assertions.assertEquals(elements,map.getElements());
    }

    @Test
    public void getElementsGrassFieldTest(){
        GrassField map=new GrassField(10);
        Animal animal1=new Animal(new Vector2D(2,3));
        Animal animal2=new Animal(new Vector2D(-1,9));
        Animal animal3=new Animal(new Vector2D(7,8));


        Assertions.assertDoesNotThrow(()->{
            map.place(animal1);
            map.place(animal2);
            map.place(animal3);

        });

        List<WorldElement> elements=new ArrayList<WorldElement>();
        elements.add(animal1);
        elements.add(animal2);
        elements.add(animal3);

        for(Grass grass : map.getGrassOnMap()){
            elements.add(grass);
        }
        Assertions.assertEquals(elements,map.getElements());
    }

    @Test
    public void grassFieldPlaceAndObjectAtTest(){
        GrassField grassField=new GrassField(10);
        Animal animal=new Animal(new Vector2D(2,2));
        Grass grass=new Grass(new Vector2D(1,1));


        Assertions.assertDoesNotThrow(()->{
            grassField.place(animal);
            grassField.place(grass);

        });


        Assertions.assertEquals(grassField.objectAt(new Vector2D(2,2)), animal);
        Assertions.assertEquals(grassField.objectAt(new Vector2D(1,1)),grass);

    }

    @Test
    public void grassFieldIsOccupiedTest(){
        GrassField grassField=new GrassField(10);
        Animal animal=new Animal(new Vector2D(2,2));
        Animal animal2=new Animal(new Vector2D(2,5));
        Grass grass=new Grass(new Vector2D(1,1));
        Grass grass2=new Grass(new Vector2D(-1,-8));



        Assertions.assertDoesNotThrow(()->{
            grassField.place(animal);
            grassField.place(animal2);
            grassField.place(grass);
            grassField.place(grass2);

        });


        Assertions.assertTrue(grassField.isOccupied(new Vector2D(2,2)));
        Assertions.assertTrue(grassField.isOccupied(new Vector2D(1,1)));
        Assertions.assertTrue(grassField.isOccupied(new Vector2D(2,5)));
        Assertions.assertTrue(grassField.isOccupied(new Vector2D(-1,-8)));

    }

    @Test
    public void grassFieldMovePositionTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        GrassField grassField=new GrassField(15);

        Assertions.assertDoesNotThrow(()->{

            grassField.place(animal1);
            grassField.place(animal2);
        });



        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.FORWARD); //tu animal2 próbuje wejść na pozycję zajmowaną przez animal1 - mapa na to nie pozwala

        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal2,MoveDirection.BACKWARD);

        Assertions.assertEquals(animal1.getPosition(),new Vector2D(0,1));
        Assertions.assertEquals(animal2.getPosition(),new Vector2D(1,4));
        Assertions.assertEquals(grassField.getAnimals().get(new Vector2D(0,1)), animal1);
        Assertions.assertEquals(grassField.getAnimals().get(new Vector2D(1,4)), animal2);
        Assertions.assertEquals(grassField.objectAt(new Vector2D(0,1)), animal1);
        Assertions.assertEquals(grassField.objectAt(new Vector2D(1,4)), animal2);

        Assertions.assertDoesNotThrow(()->{

            grassField.place(new Grass(new Vector2D(1,2)));
        });



        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.LEFT);

        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal1,MoveDirection.FORWARD); //animal1 wchodzi na trawę
        grassField.move(animal2,MoveDirection.BACKWARD);

        Assertions.assertEquals(animal1.getPosition(),new Vector2D(1,2));
        Assertions.assertEquals(animal2.getPosition(),new Vector2D(0,4));
        Assertions.assertEquals(grassField.getAnimals().get(new Vector2D(1,2)), animal1);
        Assertions.assertEquals(grassField.getAnimals().get(new Vector2D(0,4)), animal2);
        Assertions.assertEquals(grassField.objectAt(new Vector2D(1,2)), animal1);
        Assertions.assertEquals(grassField.objectAt(new Vector2D(0,4)), animal2);

    }
    @Test
    public void grassFieldMoveDirectionTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        GrassField grassField=new GrassField(15);

        Assertions.assertDoesNotThrow(()->{
            grassField.place(animal1);
            grassField.place(animal2);
        });


        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.FORWARD); //tu animal2 próbuje wejść na pozycję zajmowaną przez animal1 - mapa na to nie pozwala

        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal2,MoveDirection.BACKWARD);

        Assertions.assertEquals(animal1.getDirection(),MapDirection.SOUTH);
        Assertions.assertEquals(animal2.getDirection(),MapDirection.SOUTH);


        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal2,MoveDirection.LEFT);

        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal1,MoveDirection.LEFT);
        grassField.move(animal1,MoveDirection.FORWARD);
        grassField.move(animal2,MoveDirection.BACKWARD);

        Assertions.assertEquals(animal1.getDirection(),MapDirection.NORTH);
        Assertions.assertEquals(animal2.getDirection(),MapDirection.EAST);

    }

    @Test
    public void RectangularMapPlaceTest(){
        RectangularMap map=new RectangularMap(7,8);
        Animal animal1=new Animal(new Vector2D(2,3));
        Animal animal2=new Animal(new Vector2D(-1,9));
        Animal animal3=new Animal(new Vector2D(7,8));

        Assertions.assertDoesNotThrow(()->{
            boolean res1=map.place(animal1);

        });

        Assertions.assertThrows(PositionAlreadyOccupiedException.class,()->{
            boolean res2=map.place(animal2);
        });



        Assertions.assertDoesNotThrow(()->{
            boolean res3=map.place(animal3);

        });





        Assertions.assertEquals(map.objectAt(new Vector2D(2,3)),animal1);
        Assertions.assertNull(map.objectAt(new Vector2D(-1, 9)));
        Assertions.assertEquals(map.objectAt(new Vector2D(7,8)),animal3);

        RectangularMap map1=new RectangularMap(3,2);
        Animal animal4=new Animal(new Vector2D(2,2));
        Animal animal5=new Animal(new Vector2D(-1,9));
        Animal animal6=new Animal(new Vector2D(1,0));

        Assertions.assertDoesNotThrow(()->{
            boolean res4=map1.place(animal4);

        });

        Assertions.assertThrows(PositionAlreadyOccupiedException.class,()->{
            boolean res5=map1.place(animal5);
        });



        Assertions.assertDoesNotThrow(()->{
            boolean res6=map1.place(animal6);

        });


        Assertions.assertEquals(map1.objectAt(new Vector2D(2,2)),animal4);
        Assertions.assertNull(map1.objectAt(new Vector2D(-1, 9)));
        Assertions.assertEquals(map1.objectAt(new Vector2D(1,0)),animal6);
    }


}
