package lesson_2_4

fun main() {
    val number = 10
    when (number) {
        0 -> println("Zero")
        10 -> println("It is ten")
        else -> println("Non-zero")
    }

    val string = "Dog"
    when(string){
        "Car", "Dog" -> println("Animal is a house pet")
        else -> println("Animal is not house pet")
    }

    when(number){
        in 0..9 -> println("Between 0  and 9")
        in 10..20 -> println("Between 10  and 20")
        else -> println("Some other number")
    }

    when{
        number%2 == 0 -> println("Even")
        else -> println("Odd")
    }

    val testValue = 10
    val result = when{
        testValue < 10 -> "Less than 10"
        testValue > 10 -> "Greater than 10"
        else-> "Is equal 10"
    }
    println("Result $result")

}