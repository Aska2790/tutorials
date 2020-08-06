package lesson_7_2

sealed class Expression

data class Num(val value: Double) : Expression()
data class Sum(val value1: Expression, val value2: Expression) : Expression()
object NotANumber : Expression()

fun eval(expression: Expression): Double = when (expression) {
    is Num -> expression.value
    is Sum -> eval(expression.value1) + eval(expression.value2)
    NotANumber -> Double.NaN
}

fun main() {
    val number1: Num = Num(5.5)
    val number2: Num = Num(10.0)

    val result = eval(Sum(number1, number2))
    println(result)
}