package main.concepts.controlFlow.exceptions


fun main() {
//    val cause = IllegalStateException("Original cause:illegal state")
//    throw IllegalArgumentException(cause)

    println(getIndices(-1))
}

fun getIndices(count: Int): List<Int> {
    require(count >= 0) { "Count must be non-negative. You set count to $count." }
    return List(count) { it + 1 }
}
