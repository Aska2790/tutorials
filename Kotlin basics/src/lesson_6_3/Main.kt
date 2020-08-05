package lesson_6_3

/*
* output :
* First initialization block
* Second initialization block
* Secondary constructor

* */
class Person {

    init {
        println("First initialization block")
    }

    init {
        println("Second initialization block")
    }

    constructor() {
        println("Secondary constructor")
    }
}


class Person1(val firstName: String, val lastName: String) {
    val fullname: String

    init {
        fullname = "$firstName $lastName";
    }
}

fun main() {
    val person = Person()
    val person1 = Person1("Arslan", "Annaev")
    println("Fullname ${person1.fullname}")
}