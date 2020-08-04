package lesson_4_6

fun main() {
    val immutableMap = mapOf("Anna" to 2, "Brian" to 2, "Craig" to 3)
    println(immutableMap)

    // get value by key
    var key = "Anna"
    var value = immutableMap[key]
    println(value)

    // illegal key
    key = "Greg"
    value = immutableMap[key]
    println(value)

//    immutableMap[key] = 3

    val mutableMap =  mutableMapOf("name" to "Bob", "profession" to "Card Player", "city" to "Oakland", "country" to "USA")

    println(mutableMap)

    key = "profession"
    val setValue = "Mailman"
    mutableMap[key] = setValue
    println(mutableMap)

    key = "city"
    mutableMap.remove(key)
    println(mutableMap)


    for((key, value) in mutableMap){
        println("key = $key,  value = $value")
    }

    for(key in mutableMap.keys){
        println("key = $key,  value = ${mutableMap[key]}")
    }

    println(mutableMap.isEmpty())
    println(mutableMap.isNotEmpty())
    println(mutableMap.isNullOrEmpty())
    println(mutableMap.count())

    fun printMap(map:Map<String, String>){
        for(key in map.keys){
            println("key = $key,  value = ${mutableMap[key]}")
        }
    }

    printMap(mutableMap)
}