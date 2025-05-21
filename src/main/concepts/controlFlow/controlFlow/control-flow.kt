package main.concepts.controlFlow.controlFlow

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

fun compare(a: Int, b: Int) {
    when {
        a > b -> "a is greater than b"
        a < b -> "a is less than b"
        else -> "a is equal to b"
    }

    val x = a + b
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

//    when {
//        a.isOdd() -> print("x is odd")
//        b.isEven() -> print("y is even")
//        else -> print("x+y is odd")
//    }

}

sealed interface Animal {
    data class Cat(val mouseHunter: Boolean) : Animal
    data class Dog(val breed: String) : Animal
}

fun feedAnimal(animal: Animal) {
//    when (animal) {
//        is Animal.Dog -> feedDog()
//        is Animal.Cat if !animal.mouseHunter
//        -> feedCat()
//        else -> println("Unknown animal")
//    }
}

fun main() {
    val x = "jayce"
    val y = hasPrefix(x)
    println(y)

    var i = 10
    while (i > 0) {
        i--
        println(i)
    }
    do {
        i++
    } while (i < 11)
    println(i)
}