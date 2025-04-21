package org.example.demo.control.flow

fun main11() {
    val a = 2
    val b = 3
    //sample start
    var max = a
    if (a < b) max = b
    if (a > b) {
        max = a
    } else {
        max = b
    }

    max = if (a > b) a else b
    val maxLimit = 1
    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b

    println("max is $max")
    println("maxLimit is $maxLimit")

    val max1 = if (a > b) {
        println("choose a")
        a
    } else {
        println("choose b")
        b
    }
}

fun whenFun(x: Int) {
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }
}

enum class Bit {
    ZERO, ONE, TWO, THREE, FOUR, FIVE
}

enum class Color {
    RED, GREEN, BLUE, YELLOW
}

//fun c(x: Int) {
//    when (x) {
//        in 1..10 -> print("x is in the range")
//        in validNumbers -> print("x is valid")
//        !in 10..20 -> print("x is outside the range")
//        else -> print("none of the above")
//    }
//}
//val numericValue = when (getRandomBit()) {
//    Bit.ZERO -> 0
//    Bit.ONE -> 1
//}
fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun main() {
    val x = "jayce"
    val y = hasPrefix(x)
    println(y)
}