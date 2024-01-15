package model.kotlin

import model.kotlin.util.RandomPositionGenerator

class BouncyMap(val width: Int, val height: Int) : WorldMap<Animal, Vector2d> {
    var animals = hashMapOf<Vector2d, Animal>()

    override fun canMoveTo(position: Vector2d): Boolean = position.x in 0..width && position.y in 0..height


    override fun place(animal: Animal): Boolean {
        for (pair in animals) {
            if (pair.value == animal) {
                animals.remove(pair.key)
                return bouncyPlace(animal)
            }
        }
        return bouncyPlace(animal)

    }

    override fun move(animal: Animal, direction: MoveDirection) {
        animal.move(direction, this)
        place(animal)
    }

    override fun isOccupied(position: Vector2d): Boolean = objectAt(position) == null

    override fun objectAt(pObject: Vector2d): Animal? = animals[pObject]

    fun getAnimals(): Set<Animal> {
        return animals.values.toSet()
    }

    private fun bouncyPlace(animal: Animal): Boolean {
        if (canMoveTo(animal.position) && objectAt(animal.position) == null) {
            animals[animal.position] = animal
        } else {
            var position = randomFreePosition()
            if (position != null) {
                animal.position = position
                animals[position] = animal
            } else {
                position = randomPosition(Vector2d(width, height))
                animal.position = position
                animals[position] = animal

            }
        }
        return true
    }
}