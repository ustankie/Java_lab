package model.kotlin.util

import model.kotlin.Vector2d

class RandomPositionGenerator(var choice: MutableList<Vector2d>, var n: Int) : Iterable<Vector2d?> {
    private val vectors: MutableList<Vector2d>

    init {
        n = kotlin.math.min(n, choice.size)
        vectors = choice
        vectors.shuffle()
    }

    override fun iterator(): Iterator<Vector2d> {
        return object : MutableIterator<Vector2d> {
            override fun hasNext(): Boolean {
                return n != 0
            }

            override fun next(): Vector2d {
                return vectors[--n]
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }
}
