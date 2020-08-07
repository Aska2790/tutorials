package lesson_8_5

class Person(var firstName: String, var lastName:String){
    lateinit var fullName:String

    fun getFullNames():String {
        if(!this::fullName.isInitialized){
            fullName = firstName + " " + lastName
        }
        return fullName;
    }
}


fun main() {
    val person = Person("FirstName", "LastName");
    println("${person.getFullNames()}")
}