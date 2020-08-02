package lesson_1_7

fun main(args: Array<String>) {
    val yes1: Boolean = true;
    val yes2 = true;

    val no1: Boolean = false;
    val no2 = false;

    println("yes1 = yes2 ${yes1 == yes2}")
    println("no1 = no2 ${no1 == no2}")

    val x1 = 1
    val y1 = 2

    val doesEquals = (x1 == y1);
    val doesNotEquals = (x1 != y1);

    println("Does equals $x1 and $y1 $doesEquals")
    println("Does not equals $x1 and $y1 $doesNotEquals")

    val and = true && true
    val or = true || false

    println("and $and")
    println("or $or")
}