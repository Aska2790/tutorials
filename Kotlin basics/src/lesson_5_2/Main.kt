package lesson_5_2

fun main() {

    val ints = listOf(1, 2, 3, 4, 5, 6, 7)
    val intResults = ints.filter { it > 2 }
    println(intResults)

    // predicate
    fun List<Int>.filter(operator: (Int) -> Boolean) {

    }

    val strings = listOf("Suzzy", "Jam", "Ray", "Jane")
    val stringResults = strings.filter { string -> string.length > 3 }
    println(stringResults)

    // higher-order function
    fun handleInteger(value: Int, operator: (Int) -> Unit) {
        operator(value)
    }

    //lambda 
    handleInteger(10, { value -> println("$value") })
    handleInteger(10, { println("$it") })

    fun printResult(value: Int) {
        println("Value $value")
    }

    handleInteger(44, ::printResult)
}