import io.kotest.common.platform
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import model.kotlin.*

class MapTest : ShouldSpec({
    context("canMoveTo test") {
        should("should not allow to get out of map") {
            val map = BouncyMap(1, 2)
            map.canMoveTo(Vector2d(1, 3)) shouldBe false
            map.canMoveTo(Vector2d(2, 0)) shouldBe false
            map.canMoveTo(Vector2d(-1, 1)) shouldBe false
            map.canMoveTo(Vector2d(1, -5)) shouldBe false
            map.canMoveTo(Vector2d(1, 1)) shouldBe true
        }
    }

    context("objectAt test") {
        should("objectAt should return the object at the given position") {
            val map = BouncyMap(1, 2)
            val animal = Animal(Vector2d(1, 1))
            map.place(animal)
            map.objectAt(Vector2d(1, 1)) shouldBe animal
            map.objectAt(Vector2d(0, 0)) shouldBe null
            map.move(animal, MoveDirection.FORWARD)
            map.objectAt(Vector2d(1, 2)) shouldBe animal
            map.objectAt(Vector2d(1, 1)) shouldBe null
        }
    }

    context("place test") {
        should("place should place animal on map if position free and in map") {
            val map = BouncyMap(5, 5)
            val animal = Animal(Vector2d(3, 2))

            map.place(animal) shouldBe true
            map.objectAt(Vector2d(3, 2)) shouldBe animal
            animal.position shouldBe Vector2d(3, 2)

            val animal2 = Animal(Vector2d(3, 2))

            map.place(animal2) shouldBe true
            map.objectAt(Vector2d(3, 2)) shouldBe animal
            animal2.position shouldNotBe Vector2d(3, 2)

            val animal3 = Animal(Vector2d(5, 6))

            map.place(animal3) shouldBe true
            map.objectAt(Vector2d(5, 6)) shouldBe null
            animal3.position shouldNotBe Vector2d(5, 6)
        }

        should("place should change animals position if animal already in map") {
            val map = BouncyMap(5, 5)
            val animal = Animal(Vector2d(3, 2))

            map.place(animal)
            animal.position = Vector2d(4, 5)

            map.place(animal)
            map.objectAt(Vector2d(4, 5)) shouldBe animal
            map.objectAt(Vector2d(3, 2)) shouldBe null

            val animal2 = Animal(Vector2d(3, 2))

            map.place(animal2) shouldBe true
            map.objectAt(Vector2d(3, 2)) shouldBe animal2
            animal2.position shouldBe Vector2d(3, 2)

            animal.position = Vector2d(3, 2)
            map.place(animal)
            map.objectAt(Vector2d(3, 2)) shouldBe animal2
            animal2.position shouldBe Vector2d(3, 2)

            animal.position = Vector2d(5, 6)
            map.place(animal)
            animal.position shouldNotBe Vector2d(5, 6)
        }

        should("should place animal on a free position if his is taken or out of map") {
            val map = BouncyMap(5, 5)
            val animal = Animal(Vector2d(3, 2))

            map.place(animal)

            val animal2 = Animal(Vector2d(3, 2))
            map.place(animal2)

            animal2.position shouldNotBe Vector2d(3, 2)
            map.getAnimals() shouldBe setOf(animal, animal2)

            val animal3 = Animal(Vector2d(10, 2))
            map.place(animal3)

            animal3.position shouldNotBe Vector2d(10, 2)
            map.getAnimals() shouldBe setOf(animal, animal2, animal3)
        }

        should("should bounce other animal out of map if no free position") {
            val map = BouncyMap(1, 0)
            val animal = Animal(Vector2d(1, 0))

            map.place(animal)

            val animal2 = Animal(Vector2d(0, 0))
            map.place(animal2)

            val animal3 = Animal(Vector2d(0, 0))
            map.place(animal3)

            map.getAnimals().contains(animal3) shouldBe true
            map.getAnimals().size shouldBe 2

            val animal4 = Animal(Vector2d(3, 0))
            map.place(animal4)

            map.getAnimals().contains(animal4) shouldBe true
            map.getAnimals().size shouldBe 2
        }
    }

    context("move test") {
        should("should move an animal") {
            val map = BouncyMap(5, 5)
            val animal = Animal(Vector2d(3, 2))

            map.place(animal)
            map.move(animal, MoveDirection.FORWARD)

            map.objectAt(Vector2d(3, 2)) shouldBe null
            map.objectAt(Vector2d(3, 3)) shouldBe animal
            animal.position shouldBe Vector2d(3, 3)
            animal.direction shouldBe MapDirection.NORTH

            map.move(animal, MoveDirection.LEFT)
            map.objectAt(Vector2d(3, 3)) shouldBe animal
            animal.position shouldBe Vector2d(3, 3)
            animal.direction shouldBe MapDirection.WEST

            animal.direction = MapDirection.EAST
            map.move(animal, MoveDirection.RIGHT)
            map.objectAt(Vector2d(3, 3)) shouldBe animal
            animal.position shouldBe Vector2d(3, 3)
            animal.direction shouldBe MapDirection.SOUTH

            animal.position = Vector2d(0, 0)
            map.place(animal)

            map.move(animal, MoveDirection.BACKWARD)
            animal.direction shouldBe MapDirection.SOUTH
            map.getAnimals().contains(animal) shouldBe true
            (map.animals[animal.position] == animal) shouldBe true
        }
    }

})