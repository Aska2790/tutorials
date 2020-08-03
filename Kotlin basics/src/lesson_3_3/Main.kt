package lesson_3_3

typealias operation = (a: Int, b: Int) -> Int

fun main() {
    fun printFunction(a: Int) {}
    fun printFunction(a: Int, b: Int) {}
    fun printFunction(a: Int, b: Int, c: Int) {}

    fun add(a: Int, b: Int): Int {
        return a + b;
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    println(add(a = 2, b = 34))
    println(subtract(3, 1))

    var function: (a: Int, b: Int) -> Int

    function = ::add
    println(function(3, 5))

    function = ::subtract
    println(function(5, 3))

    fun printResult(f: (a: Int, b: Int) -> Int, a: Int, b: Int) {
        val message = f(a, b)
        println(message)
    }

    printResult(::add, 3, 4)

    fun printResults(f: operation, a: Int, b: Int) {
        val message = f(a, b)
        println(message)
    }

    printResults(::subtract, 4, 2)

    fun noReturn(): Unit {

    }

    println(noReturn())
}