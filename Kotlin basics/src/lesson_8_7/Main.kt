package lesson_8_7

import kotlin.properties.Delegates

data class Course(var className: String)

data class Course1(var className: String) {
    var room: String by Delegates.observable("Not null") { _, oldValue, newValue ->
        println("old value $oldValue")
        println("new value $newValue")
    }

}

data class Course2(val map: Map<String, Any?>) {
    val room: String by map
    val teacher: String by map
    val other: String by map
}

val scienceCourse: Course by lazy {
    Course("Science")
}

fun main() {

    println(scienceCourse.className)

    val course1 = Course1("Course")
    println(course1.room)
    course1.room = "new room"

    val course2 = Course2(mapOf("room" to "Room1", "teacher" to "Ms Price", "other" to "One"));
    println(course2)
    println(course2.room)
    println(course2.teacher)
    println(course2.other)


}