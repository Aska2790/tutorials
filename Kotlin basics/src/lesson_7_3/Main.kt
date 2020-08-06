package lesson_7_3

object Singleton {
    val constant:String = "This is a constant";

    fun displayMessage(message: String) {
        println("$message")
    }
}

fun main() {
    Singleton.displayMessage(Singleton.constant)
}