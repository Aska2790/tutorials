package lesson_7_6

interface Animal {

    val numLeg: Int

    fun eat();
}

class Dog : Animal {
    override val numLeg: Int
        get() {
            return 4
        }

    override fun eat() {
        println("Dog eat")
    }
}

class Cat : Animal {

    override val numLeg: Int
        get() {
            return 4
        }

    override fun eat() {
        println("Cat eat")
    }
}


fun main() {

    val dog: Dog = Dog()
    val cat: Cat = Cat()

    dog.eat()
    cat.eat()

    println("dog numLeg ${dog.numLeg}")
    println("cat numLeg ${cat.numLeg}")

}