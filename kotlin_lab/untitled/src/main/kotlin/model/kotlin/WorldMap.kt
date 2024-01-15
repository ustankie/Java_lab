package model.kotlin

interface WorldMap<T, P> : MoveValidator<P> {

    fun place(tObject: T): Boolean;

    fun move(tObject: T, direction: MoveDirection);

    fun isOccupied(pObject: P): Boolean

    fun objectAt(pObject: P): T?

}