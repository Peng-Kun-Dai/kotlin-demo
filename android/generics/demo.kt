package android.generics

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>(
        "Quoth the raven ___",
        "nevermore",
        Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        "The sky is green. True or false",
        false,
        Difficulty.EASY
    )
    val question3 = Question<Int>(
        "How many days are there between full moons?",
        28,
        Difficulty.HARD
    )
    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

fun main() {
//    Quiz().printQuiz()

    Quiz().apply {
//        printQuiz()
    }


    val rockPlanets = arrayOf<String>( //数组
        "Mercury",
        "Venus",
        "Earth",
        "Mars"
    )
    val rockT = arrayOf("demo")
    val solar = rockPlanets + rockT
//    solar.forEach { println(it) }

//    val solarSystem = listOf( //链表
    val solarSystem = mutableListOf(
        "Mercury",
        "Venus",
        "Earth",
        "Mars"
    )
//    solarSystem.add("demo")
//    solarSystem.add(2,"demo")

//    solarSystem.removeLast()
//    solarSystem.removeAt()
//    solarSystem.indexOf("")
//    solarSystem.contains("")
//    "" in solarSystem
    for (planet in solarSystem) {
        println(planet)
    }


    //集是无序的集合。您无法按索引从集中移除某个值，因为集没有索引。
    val solarSet = mutableSetOf(
        "Mercury",
        "Venus",
        "Earth",
        "Mars"
    )

    val solarMap = mutableMapOf(
        "Mercury" to 1,
        "Venus" to 2,
        "Earth" to 5,
        "Mars" to 0
    )

}