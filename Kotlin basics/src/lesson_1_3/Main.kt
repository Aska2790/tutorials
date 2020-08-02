package lesson_1_3

fun main(args: Array<String>){

    // kotlin types
    val temperature =  37.5 // double
    val count:Int = 5       // integer
    var name = "Sam"        // string

    // changing the value of variable
    name = "Fred"

    // function
    fun calculateTemperature(celsius:Double):Double{
        return 9/5*celsius + 32
    }

    println("Temperature = ${calculateTemperature(20.0)}")

    //convert string to integer
    val intValue = "32".toInt()
    println("IntValue $intValue")

    // convert integer to string
    val intString  = 32.toString()
    println("IntString $intString")


    // when statement
    var fahrenheit = 32
    when(fahrenheit){
        in 0..30 -> println("Really cold")
        in 31..40 -> println("Getting colder")
        in 41..50 -> println("Kind of cold")
        in 51..60 -> println("Nippy")
        in 61..70 -> println("Just right")
    }


    // nullable string
    var nullableString:String?;
    nullableString =  null

    var length = nullableString?.length ?:-1;
    println("Length $length")

    nullableString = "String"
    length = nullableString?.length ?:-1;
    println("Length $length")
}