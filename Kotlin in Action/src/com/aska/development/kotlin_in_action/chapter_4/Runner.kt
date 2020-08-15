package com.aska.development.kotlin_in_action.chapter_4

sealed class Expression

data class Num(val number: Double) : Expression()
data class Sum(val expression1: Expression, val expression2: Expression) : Expression()
object NotNumber : Expression()

fun main() {
    val button: Clickable = Button()
    val imageButton: Clickable = ImageButton()

    button.click()
    imageButton.click()

    val someView: Focusable = SomeView()

    button.showOff()
    imageButton.showOff()
    someView.showOff()

    println("======================================================")

    val richButton: RichButton = RichButton()
    richButton.setFocus(true)
    richButton.showOff()
    richButton.setFocus(false)

    println("======================================================")

    val animatedButton: Button = Button()
    animatedButton.animate()
    animatedButton.animateTwice()
    animatedButton.stopAnimating()

    println("======================================================")

    val richButtonSubClass: RichButtonSubClass = RichButtonSubClass()
    richButtonSubClass.showOff()
    richButtonSubClass.animate()
    richButtonSubClass.click()

    println("======================================================")

    button.log("log message")

    println("======================================================")
    println("Nested and Inner class")

    var buttonState: State = Button().getCurrentState()
    val outerReference: Button = Button().getDebugInfo().getOuterReference()
    buttonState = outerReference.getCurrentState()

    println("======================================================")
    println("Sealed class")

    val number1: Num = Num(5.0)
    val number2: Num = Num(5.5)

    fun eval(e: Expression): Double {
        val d = when (e) {
            is Num -> e.number
            is Sum -> eval(e.expression1) + eval(e.expression2)
            is NotNumber -> Double.NaN
        }
        return d
    }

    println("Sum ${number1.number} + ${number2.number} = ${eval(Sum(number1, number2))}")

    println("======================================================")
    println("Class primary constructor")

    val user: User = User("Duck")
    println("User nickname ${user.nickname}")

    val user1: User1 = User1("Alice")
    println("User nickname ${user1.nickname}")

    val user2: User2 = User2("John")
    println("User nickname ${user2.nickname}")

    val user3: User3 = User3("Bob")
    println("User nickname ${user3.nickname} is subscribed ${user3.isSubscribed}")

    val user4: User3 = User3("Dan", isSubscribed = true)
    println("User nickname ${user4.nickname} is subscribed ${user4.isSubscribed}")

    println("======================================================")
    println("Super class constructor")

    val twitterUser: TwitterUser = TwitterUser("User")
    val radioButton: RadioButton = RadioButton()

    /* Приватный конструктор*/
    class SecretiveObject private constructor()

    println("======================================================")

    /*Класс с несколькими конструкторами*/
    val myButton: MyButton = MyButton()

    println("======================================================")


}