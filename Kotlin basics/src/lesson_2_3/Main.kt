package lesson_2_3

fun main() {
    val range = 1..5

    val count = 10
    var sum = 0
    for (i in 1..count) {
        sum += i
    }

    println("sum $sum")

    for (i in 1..count) {
        println("Hodor!")
    }

    for (i in 1..count) {
        if (i % 2 == 1) {
            println("$i is an odd number     ")
        }
    }

    for (i in 1..count) {
        println("Hello")
        if (i == 3) {
            continue
        }
        println("Goodbye")
    }


    for (row in 1..3) {
        for (column in 1..3) {
            println("row $row and column $column")
        }
    }

    // label
    outer@
    for (row in 1..3) {
        for (column in 1..3) {
            if (row == 2 && column == 2) {
                continue@outer;
            }
            println("row $row column $column")
        }
    }
}