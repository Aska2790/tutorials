package lesson_7_8

import sun.misc.MessageUtils.where

enum class Direction {
    NORTH, SOUTH, WEST, EAST;

    fun printDirection() {
        println("this is $this direction")
    }
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
}

fun drive(direction: Direction) {
    when (direction) {
        Direction.NORTH -> println("Drive north")
        Direction.SOUTH -> println("Drive south")
        Direction.WEST -> println("Drive west")
        Direction.EAST -> println("Drive east")
    }
}

fun main() {
    drive(Direction.WEST)

    Direction.WEST.printDirection()
}