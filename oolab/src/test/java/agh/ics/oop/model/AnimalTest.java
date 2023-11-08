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
        MoveValidator <Vector2D> validator=new MoveValidator<Vector2D>()  {
            @Override
            public boolean canMoveTo(Vector2D position) {
                return position.getX() <= 4 && position.getY() <= 4
                        && position.getX() >= 0 && position.getY() >= 0;
            }
        };

        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.FORWARD,validator);
        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.FORWARD,validator);

        animal2.move(MoveDirection.RIGHT,validator);
        animal2.move(MoveDirection.FORWARD,validator);
        animal2.move(MoveDirection.LEFT,validator);
        animal2.move(MoveDirection.BACKWARD,validator);

        Assertions.assertTrue(animal1.isAt(new Vector2D(0,1)));
        Assertions.assertTrue(animal2.isAt(new Vector2D(2,2)));
    }

    @Test
    public void movePositionTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        MoveValidator <Vector2D> validator=new MoveValidator<Vector2D>() {
            @Override
            public boolean canMoveTo(Vector2D position) {
                return position.getX() <= 4 && position.getY() <= 4
                        && position.getX() >= 0 && position.getY() >= 0;
            }
        };

        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.FORWARD,validator);
        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.FORWARD,validator);

        animal2.move(MoveDirection.RIGHT,validator);
        animal2.move(MoveDirection.FORWARD,validator);
        animal2.move(MoveDirection.LEFT,validator);
        animal2.move(MoveDirection.BACKWARD,validator);

        Assertions.assertEquals(animal1.getPosition(),new Vector2D(0,1));
        Assertions.assertEquals(animal2.getPosition(),new Vector2D(2,2));

    }

    @Test
    public void moveOrientationTest(){
        Animal animal1=new Animal(new Vector2D(1,2));
        Animal animal2=new Animal(new Vector2D(1,3));

        MoveValidator <Vector2D> validator=new MoveValidator<Vector2D>() {
            @Override
            public boolean canMoveTo(Vector2D position) {
                return position.getX() <= 4 && position.getY() <= 4
                        && position.getX() >= 0 && position.getY() >= 0;
            }
        };

        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.FORWARD,validator);
        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.FORWARD,validator);

        animal2.move(MoveDirection.RIGHT,validator);
        animal2.move(MoveDirection.FORWARD,validator);
        animal2.move(MoveDirection.LEFT,validator);
        animal2.move(MoveDirection.BACKWARD,validator);

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


        MoveValidator <Vector2D> validator=new MoveValidator<Vector2D>() {
            @Override
            public boolean canMoveTo(Vector2D position) {
                return position.getX() <= 4 && position.getY() <= 4
                        && position.getX() >= 0 && position.getY() >= 0;
            }
        };

        animal1.move(MoveDirection.BACKWARD,validator);

        animal2.move(MoveDirection.RIGHT,validator);
        animal2.move(MoveDirection.FORWARD,validator);

        animal3.move(MoveDirection.LEFT,validator);
        animal3.move(MoveDirection.FORWARD,validator);

        animal4.move(MoveDirection.LEFT,validator);
        animal4.move(MoveDirection.BACKWARD,validator);

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

        String a1="S";
        String a2="N";

        Assertions.assertEquals(animal1.toString(),a1);
        Assertions.assertEquals(animal2.toString(),a2);

    }



}
