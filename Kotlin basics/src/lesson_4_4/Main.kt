package lesson_4_4

fun main() {
    val immutableList = listOf("Anna", "Brian", "Craig", "Donna")
    println(immutableList)

    val mutableList = mutableListOf<String>()
    println(mutableList)

    mutableList.addAll(immutableList)
    println(mutableList)

    mutableList.add("Sam")
    mutableList.add("Jan")
    println(mutableList)

    val index = 1
    println("item with index $index  = ${mutableList[index]}")
    println("item with index $index  = ${mutableList.get(index)}")

    val item = "Sam"
    println("Index of item $item = ${mutableList.indexOf(item)}")

    mutableList.remove(item)
    println(mutableList)

    for(value in mutableList){
        println("Item $value")
    }
}