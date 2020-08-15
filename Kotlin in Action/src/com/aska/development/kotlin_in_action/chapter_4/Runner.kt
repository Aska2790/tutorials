package com.aska.development.kotlin_in_action.chapter_4

fun main() {
    val button: Clickable = Button()
    val imageButton:Clickable = ImageButton()

    button.click()
    imageButton.click()

    val someView : Focusable = SomeView()

    button.showOff()
    imageButton.showOff()
    someView.showOff()

    println("======================================================")

    val richButton : RichButton = RichButton()
    richButton.setFocus(true)
    richButton.showOff()
    richButton.setFocus(false)

    println("======================================================")

    val animatedButton : Button = Button()
    animatedButton.animate()
    animatedButton.animateTwice()
    animatedButton.stopAnimating()

    println("======================================================")

    val richButtonSubClass: RichButtonSubClass = RichButtonSubClass()
    richButtonSubClass.showOff()
    richButtonSubClass.animate()
    richButtonSubClass.click()

    println("======================================================")

}