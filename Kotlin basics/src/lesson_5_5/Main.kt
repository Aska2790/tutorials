package lesson_5_5

interface Repository<T> {
    fun addItem(item: T)
    fun removeItem(item: T)
}

class Person(val value: String) {}

class RepositoryImpl : Repository<Person> {
    override fun addItem(item: Person) {}
    override fun removeItem(item: Person) {}
}

fun <T> printItem(item: T) {
    println(item)
}

fun main() {
    printItem("Hello")
}