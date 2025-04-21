fun double(x: Int): Int {
    return x * 2
}

fun power(number: Int, exponent: Int): Int {
    /**
     *
     */
    return number * exponent
}

fun read(
    b: ByteArray,
    off: Int,
    len: Int = b.size,
) {
    /**
     *
     */

}

open class A1 {
    open fun foo(i: Int = 10) {}
}

class B1 : A1() {
    override fun foo(i: Int) {}
}

fun main() {
    val result = double(2)
}