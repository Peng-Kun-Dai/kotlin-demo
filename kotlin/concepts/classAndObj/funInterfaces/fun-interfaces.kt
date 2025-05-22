package example.concepts.classAndObj.funInterfaces

fun interface KRunnable {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}
val isEven2 = IntPredicate {
    it % 2 == 0
}

interface Printer {
    fun print()
}

fun main() {
    println("Is 7 even? = ${isEven2.accept(7)}")
}