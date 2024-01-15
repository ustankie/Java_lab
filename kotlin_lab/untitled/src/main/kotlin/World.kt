import model.kotlin.*


fun main() {
    val vector1 = Vector2d(4, 4)
    val vector2 = Vector2d(3, 3)

    val dir1 = MapDirection.NORTH
    println("${dir1.previous()} ${dir1.next()} ${MoveDirection.RIGHT}")

    val animal = Animal(Vector2d(1, 2));
    val animal2 = Animal(Vector2d(0, 0))
    var map = BouncyMap(1, 1)
    map.place(animal)
    map.place(animal2)
    println(map.animals)
    map.move(animal, MoveDirection.BACKWARD)
    println(map.animals)

}
