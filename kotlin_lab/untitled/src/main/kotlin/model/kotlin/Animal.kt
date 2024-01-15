package model.kotlin


class Animal(var position: Vector2d, var direction: MapDirection = MapDirection.NORTH) {

    override fun toString(): String {
        return direction.toString();
    }

    fun isAt(position: Vector2d) = position == this.position

    fun move(moveDirection: MoveDirection, validator: MoveValidator<Vector2d>) = when {
        moveDirection == MoveDirection.LEFT -> direction = (direction.previous())
        moveDirection == MoveDirection.RIGHT -> direction = direction.next()
        moveDirection == MoveDirection.BACKWARD -> position -= direction.toUnitVector()
        moveDirection == MoveDirection.FORWARD -> position += direction.toUnitVector()
        else -> {}
    }
}