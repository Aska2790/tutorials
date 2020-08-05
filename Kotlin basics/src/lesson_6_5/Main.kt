package lesson_6_5

class Grade(var letter: Char, var points: Double, var credits: Double) {}

open class Person(var firstname :String , var lastname:String){}

open class Student(firstName: String, lastName: String,
              var grades: ArrayList<Grade> = ArrayList()): Person(firstName, lastName){

    fun recordGradle(grade:Grade){
        grades.add(grade)
    }
}

open class BandMember(firstName: String, lastName: String): Student(firstName, lastName){
    open var minimumPractice = 2
}

class OboePlayer(firstName: String, lastName: String): BandMember(firstName, lastName){
    override var minimumPractice: Int
        get() {
            return super.minimumPractice *2
        }
        set(value) {
            super.minimumPractice = value/2
        }
}

fun main() {

    val person = Person("Johny", "Sample");
    val student = Student("Alice", "Sample2");

    println(person.firstname)
    println(person.lastname)

    println(student.firstname)
    println(student.lastname)
    println(student.grades)

    val  history = Grade('B', 9.0 , 3.0)
    student.recordGradle(history)
    println(student.grades)

    person.lastname = ""
    person.firstname = ""

    val oboePlayer = OboePlayer("Jane", "Appleseed")
    var hallMonitor =  Student("Johnny", "asdasd")
    (oboePlayer as BandMember).minimumPractice = 4


    (hallMonitor as? BandMember)?.let {
        println("value ${hallMonitor.minimumPractice}")
    }

    var hallMonitor2 =  Student("Johnny", "asdasd")
    hallMonitor2 = oboePlayer
    (hallMonitor2 as? BandMember)?.let {
        println("value ${hallMonitor2.minimumPractice}")
    }

}