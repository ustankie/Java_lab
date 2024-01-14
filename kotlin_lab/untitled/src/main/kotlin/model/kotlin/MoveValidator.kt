package model.kotlin

interface MoveValidator<P> {
    fun canMoveTo(position: P): Boolean;
}