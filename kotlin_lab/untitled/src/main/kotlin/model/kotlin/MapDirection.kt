package model.kotlin

import model.kotlin.Vector2d


enum class MapDirection(i: Int) {
    NORTH(1),
    EAST(2),
    SOUTH(3),
    WEST(4);

    override fun toString(): String = when (this) {
        NORTH -> "N";
        SOUTH -> "S";
        WEST -> "W";
        EAST -> "E";
    }

    operator fun next() = entries.toTypedArray().elementAt(
        (
                this.ordinal + 1) % MapDirection.entries.size
    )

    fun previous() = entries.toTypedArray().elementAt(
        (
                this.ordinal - 1 + MapDirection.entries.size) % MapDirection.entries.size
    )


}