package model.kotlin

import kotlin.math.max
import kotlin.math.min

fun MapDirection.toUnitVector(): Vector2d = when (this) {
    MapDirection.NORTH -> Vector2d(0, 1);
    MapDirection.SOUTH -> Vector2d(0, -1);
    MapDirection.WEST -> Vector2d(-1, 0);
    MapDirection.EAST -> Vector2d(1, 0);
}

data class Vector2d(val x: Int, val y: Int) : Comparable<Vector2d> {
    fun opposite() = Vector2d((-1) * x, (-1) * y)

    operator fun plus(addVector: Vector2d) = Vector2d(addVector.x + x, addVector.y + y)

    operator fun minus(subVector: Vector2d) = Vector2d(x - subVector.x, y - subVector.y)

    fun upperRight(other: Vector2d) = Vector2d(max(x, other.x), max(y, other.y))

    fun lowerLeft(other: Vector2d) = Vector2d(min(x, other.x), min(y, other.y))

    override fun compareTo(other: Vector2d): Int = when {
        x >= other.x && y >= other.y -> 1
        x <= other.x && y <= other.y -> -1
        else -> 0
    }


}
