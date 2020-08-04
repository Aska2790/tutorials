package lesson_4_2

fun main() {

    fun printIntArray(array:Array<Int>){
        print("[ ")
        for(value in array){
            print("$value ")
        }
        println("]")
    }

    fun printStringArray(array:Array<String>){
        print("[")
        for(value in array){
            print("$value ")
        }
        println("]")
    }

    fun printStringList(list:List<String>){
        print("[")
        for(value in list){
            print("$value ")
        }
        println("]")
    }

    val evenNumbers = arrayOf(2, 4, 6, 8)
    printIntArray(evenNumbers)

    val eventNumbersExplicit:Array<Int> = arrayOf(2,4,6)
    printIntArray(eventNumbersExplicit)

    val players = arrayOf("Alice", "Bob", "Cindy", "Dan")
    printStringArray(players)

    println("players count ${players.size}")
    println("is players empty ${players.isEmpty()}")
    println("first player ${players.first()}")
    println("first player ${players[0]}")
    println("players contains Alice? ${players.contains("Alice")}")

    val playersSlice = players.slice(1..3)
    printStringList(playersSlice)

    players[0] = "Sammy"
    printStringArray(players)

    fun sumAllItems(items:Array<Int>) : Int{
        var sum : Int = 0
        for(item in items){
            sum += item
        }
        return sum
    }

    println(sumAllItems(evenNumbers))

    val dropOnePlayer =  players.drop(1)
    printStringList(dropOnePlayer)

    val dropTwoPlayer =  players.drop(2)
    printStringList(dropTwoPlayer)
}