package model.kotlin

fun BouncyMap.randomFreePosition(): Vector2d? {
    var freeFields = mutableListOf<Vector2d>()
    for (i in 0..width) {
        for (j in 0..height) {
            if (objectAt(Vector2d(i, j)) == null) {
                freeFields.add(Vector2d(i, j))
            }
        }
    }
    return freeFields.randomOrNull()
}

fun <T> WorldMap<T, Vector2d>.randomPosition(mapSize: Vector2d) =
    Vector2d((0..mapSize.x).random(), (0..mapSize.y).random())
