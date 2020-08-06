package lesson_7_5

class Student private constructor() {
    var firstName: String? = null
    var lastName: String? = null

    companion object Loader {
        fun load() :Student {
            val student = Student()
            student.firstName = "Student name"
            student.lastName = "Student lastname"
            return student
        }
    }
}

fun main() {

    val student = Student.load()
    println("first name ${student.firstName}, lastname ${student.lastName} ")

}