package main.kotlin.concepts.types.basic.unsigned

@OptIn(ExperimentalUnsignedTypes::class)
fun main() {
    val ub: UByte = 255u
    val us: UShort = 0u
    val vi: UInt = 0u
    val ul: ULong = 2u

    val uba: UByteArray = ubyteArrayOf(1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u)

    val yellow = Color(0xFFCC00CCu)
    println(yellow)

    val byteOrderMarkUtf8 = ubyteArrayOf(0xEFu, 0xBBu, 0xBFu)
    println(byteOrderMarkUtf8)
}

data class Color(val representation: UInt)
