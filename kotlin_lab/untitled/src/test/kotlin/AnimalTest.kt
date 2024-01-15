import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import model.kotlin.*

class AnimalTest : ShouldSpec( {
    context("toString tests"){
        should("should return animal's direction"){
            Animal(Vector2d(1,2),MapDirection.EAST).toString() shouldBe "E"
            Animal(Vector2d(3,5),MapDirection.NORTH).toString() shouldBe "N"
            Animal(Vector2d(3,5),MapDirection.WEST).toString() shouldBe "W"
            Animal(Vector2d(3,7),MapDirection.SOUTH).toString() shouldBe "S"
        }
        should("should return North"){
            Animal(Vector2d(3,5)).toString() shouldBe "N"
        }
    }

    context("isAt test"){
        should("should return true if animal on the given position"){
            Animal(Vector2d(1,2)).isAt(Vector2d(1,2)) shouldBe true
            Animal(Vector2d(2,3)).isAt(Vector2d(1,2)) shouldBe false
        }
    }

    context("move test"){
        should("should change animal's position and direction properly"){
            val map=BouncyMap(3,4)
            val animal=Animal(Vector2d(1,2))
            animal.move(MoveDirection.RIGHT,map)
            animal.direction shouldBe MapDirection.EAST
            animal.position shouldBe  Vector2d(1,2)

            animal.move(MoveDirection.FORWARD, map)
            animal.direction shouldBe MapDirection.EAST
            animal.position shouldBe Vector2d(2, 2)
        }
    }
})