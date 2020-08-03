package lesson_3_2

fun main() {
    fun printMyName() {
        println("My name is Tim")
    }

    printMyName()

    fun printMultiplyOfFive(value: Int) {
        println("$value * 5 = ${value * 5}")
    }

    printMultiplyOfFive(10)

    fun printMultiplyOf(value: Int, multiplier: Int) {
        println("$value * $multiplier = ${multiplier * value}")
    }

    printMultiplyOf(10, 32)

    fun printMultiplyDef(value: Int, multiplier: Int = 1) {
        println("$value * $multiplier = ${multiplier * value}")
    }

    printMultiplyDef(5)

    fun multiply(value: Int, multiplier: Int): Int {
        return value * multiplier;
    }

    val value: Int = 10
    val multiplier: Int = 12

    println("$value * $multiplier = ${multiply(value, multiplier)}")

    fun multiplyAndDivide(value:Int, factor:Int) : Pair<Int, Int>{
        return Pair(value*factor, value/factor)
    }

    println("Multiply & Divide ${multiplyAndDivide(10,2)}")
}