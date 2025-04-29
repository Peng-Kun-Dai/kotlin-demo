package main.kotlin.concepts.classAndObj.enumClasses

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator
import kotlin.enums.enumEntries as enumEntries1


enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}

enum class RGB {
    RED,
    GREEN,
    BLUE
}

inline fun <reified T : Enum<T>> printAllValues() {
    println(enumEntries1<T>().joinToString { it.name })
}

fun main() {
    for (color in RGB.entries) println(color.toString()) // 输出结果为 RED, GREEN, BLUE
    println("The first color is: ${RGB.valueOf("RED")}") // 输出结果为 "The first color is: RED"

    println(RGB.RED.name)    // 输出结果为 RED
    println(RGB.RED.ordinal) // 输出结果为 0
    printAllValues<RGB>()
}