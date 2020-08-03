package lesson_3_5

fun main() {
     var nickname: String? = null
    fun printNickname(nickname:String?){
        println("Nickname is $nickname")
    }

    printNickname(nickname)
    nickname = "Kev"
    printNickname(nickname)
}