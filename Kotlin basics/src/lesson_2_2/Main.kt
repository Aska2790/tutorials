package lesson_2_2

fun main() {

    println("while loop")
    var i = 1
    while (i < 10) {
        print(i)
        i += 1
    }

    println("----------------")

    println("do while loop")
    var j = 0
    do {
        print(j)
        j += 1
    }while (j < 10)

    println("----------------")

    do {

        if(j == 5){
            break
        }

        print(j)
        j += 1
    }while (j < 10)
}