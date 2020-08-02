package lesson_1_5

fun main(args:Array<String>){

    val coordinates = Pair(1, 3)
    println("first ${coordinates.first}  second ${coordinates.second}")
    println("Coordinates $coordinates")

    val coordinatesDouble = Pair(1.0, 3.0)
    println("first ${coordinatesDouble.first}  second ${coordinatesDouble.second}")

    val coordinatesMixed = Pair(1.0, 3)
    println("first ${coordinatesMixed.first}  second ${coordinatesMixed.second}")

    val (a1, a2) = coordinates
    println("a1 = $a1, a2 = $a2")

    val coordinates3D = Triple(1,2,3)

    val (b1, b2, b3 ) = coordinates3D;
    println("b1 = $b1, b2 = $b2, b3 = $b3")
    println("Coordinates3D $coordinates3D")

    val (c1, c2, _) = coordinates3D
    println("c1 = $c1, c2 = $c2")

}