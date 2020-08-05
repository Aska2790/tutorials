package lesson_6_7

fun main() {

    data class Podcast(val title:String, val description:String, val utl:String)

    val podcast = Podcast("Android Central",
        "The premier source for weekly news", "http://feeds.feedburn.com")
    println(podcast)

    val podcast1 = podcast.copy(title = "Developers Backstage")
    println(podcast1)
}
