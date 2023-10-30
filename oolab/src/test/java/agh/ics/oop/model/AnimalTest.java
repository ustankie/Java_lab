package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void dataInterpretationTest(){
        Animal animal=new Animal(new Vector2D(1,2));

        Assertions.assertNotNull(animal.getPosition());
        Assertions.assertTrue(animal.getPosition() instanceof Vector2D);

        Assertions.assertNotNull(animal.getDirection());
        Assertions.assertTrue(animal.getDirection() instanceof MapDirection);

        Assertions.assertEquals(animal.getPosition() ,new Vector2D(1,2));
        Assertions.assertEquals(animal.getDirection(),MapDirection.NORTH);
    }
    @Test
    public void isAtTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);

        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.BACKWARD);

        Assertions.assertTrue(animal1.isAt(new Vector2D(0,1)));
        Assertions.assertTrue(animal2.isAt(new Vector2D(2,2)));
    }

    @Test
    public void movePositionTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);

        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.BACKWARD);

        Assertions.assertEquals(animal1.getPosition(),new Vector2D(0,1));
        Assertions.assertEquals(animal2.getPosition(),new Vector2D(2,2));

    }

    @Test
    public void moveOrientationTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);

        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.BACKWARD);

        Assertions.assertEquals(animal1.getDirection(),MapDirection.SOUTH);
        Assertions.assertEquals(animal2.getDirection(),MapDirection.NORTH);
    }

    @Test
    public void moveIsInMapTest(){
        Animal animal1=new Animal(new Vector2D(1,0));
        Animal animal2=new Animal(new Vector2D(1,4));
        Animal animal3=new Animal(new Vector2D(0,4));
        Animal animal4=new Animal(new Vector2D(4,4));

        Animal[] animals={animal1,animal2,animal3,animal4};

        animal1.move(MoveDirection.BACKWARD);

        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.FORWARD);

        animal3.move(MoveDirection.LEFT);
        animal3.move(MoveDirection.FORWARD);

        animal4.move(MoveDirection.LEFT);
        animal4.move(MoveDirection.BACKWARD);

        for(Animal animal:animals){
            Assertions.assertFalse(animal.getPosition().x()<0
                    || animal.getPosition().x()>4
                    || animal.getPosition().y()<0
                    || animal.getPosition().y()>4);
        }
    }

    @Test
    public void toStringTest(){
        Animal animal1=new Animal(new Vector2D(2,4));
        Animal animal2=new Animal(new Vector2D(1,0));

        animal1.setDirection(MapDirection.SOUTH);

        String a1="(2,4) Południe";
        String a2="(1,0) Północ";

        Assertions.assertEquals(animal1.toString(),a1);
        Assertions.assertEquals(animal2.toString(),a2);

    }



}
