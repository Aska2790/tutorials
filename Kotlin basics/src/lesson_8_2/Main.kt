package lesson_8_2

class Person {
    var firstName: String? = null
    var lastName: String? = null

}

class Person1(val firstName: String, val lastName: String) {
    val fullname: String
        get() {
            return "$firstName $lastName"
        }

    var property: String = ""
        private set

    var items : List<String> = ArrayList()
        set(value) {
            field = value
        }

}


fun main() {
    val person = Person()
    person.firstName = "FirstName"
    person.lastName = "LastName"

    val person1 = Person1("FirstName", "LastName")
    println("FirstName ${person1.firstName} LastName ${person1.lastName}")
    println("Fullname ${person1.fullname}")
    println("Property ${person1.property}")


    person1.items = listOf("One", "Two")
    println(person1.items)
}