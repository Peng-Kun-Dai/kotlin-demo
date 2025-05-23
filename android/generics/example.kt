package android.generics

data class Event(
    val title: String,
    val description: String? = null,
    val dayPart: DayTime,
    val durationInMinutes: Int,
)

enum class DayTime {
    MORNING,
    AFTERNOON,
    EVENING
}

val event1 = Event(
    title = "Wake up",
    description = "Time to get up",
    dayPart = DayTime.MORNING,
    durationInMinutes = 0
)
val event2 = Event(
    title = "Eat breakfast",
    dayPart = DayTime.MORNING,
    durationInMinutes = 15
)
val event3 = Event(
    title = "Learn about Kotlin",
    dayPart = DayTime.AFTERNOON,
    durationInMinutes = 30
)
val event4 = Event(
    title = "Practice Compose",
    dayPart = DayTime.AFTERNOON,
    durationInMinutes = 60
)
val event5 = Event(
    title = "Watch latest DevBytes video",
    dayPart = DayTime.AFTERNOON,
    durationInMinutes = 10
)
val event6 = Event(
    title = "Check out latest Android Jetpack library",
    dayPart = DayTime.EVENING,
    durationInMinutes = 45
)

fun main() {
//    println(
//        Event(
//            title = "Study Kotlin",
//            description = "Commit to studying Kotlin at least 15 minutes per day.",
//            dayPart = DayTime.EVENING,
//            durationInMinutes = 15
//        )
//    )
    val events = mutableListOf<Event>(
        event1,
        event2,
        event3,
        event4,
        event5,
        event6
    )

    val shortEvents = events.filter {
        it.durationInMinutes < 60
    }

    val timeType = events.groupBy { it.dayPart }
    timeType.forEach {
        println("${it.key}: ${it.value.size} events")
    }

    println("Last event of the day: ${events[events.size - 1].title}")
    println("Last event of the day: ${events.last().title}")


}

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }