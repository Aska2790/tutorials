package lesson_6_2

// Empty class
class Person {

}

// class with properties
class Person1 {
    var firstName: String = ""
    var lastName: String = ""
}

//class with primary constructor
class Person2(
    val firstName: String,
    val lastName: String
) {
}

//class with primary and secondary constructor
class Person3(val firstName: String) {

    var lastName: String? = null

    constructor(firstName: String, lastName: String) : this(firstName) {
        this.lastName = lastName;
    }
}

fun main() {
    val person: Person = Person()


    val person1: Person1 = Person1()
    person1.firstName = "Arslan"
    person1.lastName = "Annaev"
    println("First name ${person1.firstName} Last name ${person1.lastName} ")

    val person2 = Person2("Arslan", "Annaev")
    println("First name ${person2.firstName} Last name ${person2.lastName} ")

    val person3 = Person3("Arslan", "Annaev")
    println("First name ${person3.firstName} Last name ${person3.lastName} ")
}