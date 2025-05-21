package main.concepts.types.basic.number

val byte: Byte = 1 //8bit
val short: Short = 12345 //16bit
val int: Int = 123456789 //32bit
val long = 1454533754357438L //L  long  64bit


val floatDemo: Float = 2.7182818284f //32bit
val doubleDemo: Double = 12.34 //64bit


fun main1() {
    println("Byte: $byte")
    println("Short: $short")
    println("Int: $int")
    println("Long: $long")
    println("Float: $floatDemo")
    println("Double: $doubleDemo")

    fun printDouble(d: Double) {
        print(d)
    }

    val i = 1
    val d = 1.0
    val f = 1.0f
    printDouble(d)

    val oneMillion = 1_000_000_000
    val creditCardNumber = 1234_5678_9012_345678L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
}

fun main2() {
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10_000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println("boxedA: $boxedA")
    println("boxedB: $boxedB")
    println("anotherBoxedA: $anotherBoxedA")
    println("anotherBoxedB: $anotherBoxedB")
    println(boxedA === anotherBoxedA)
    //由于 JVM 对 -128 到 127 的整数（Integer）应用了内存优化，因此，a 的所有可空引用实际上都是同一对象。但是没有对 b 应用内存优化，所以它们是不同对象。
    //数值相同，但实际对象不同
    println(boxedB === anotherBoxedB) //object
    println(boxedB == anotherBoxedB) //value
}

fun main3() {
//    较小的类型不能隐式转换为较大的类型。
//    val a: Int? = 1
//    val b: Long? = a
//    print(a == b)

    val b: Byte = 1
    val i1: Int = b.toInt()
    val i2: Short = b.toShort()
    val i3: Long = b.toLong()
    val i4: Float = b.toFloat()
    val i5: Double = b.toDouble()
    println("Byte: $b")
    println("Short: $i2")
    println("Int: $i1")
    println("Long: $i3")
    println("Float: $i4")
    println("Double: $i5")
}

fun main4() {

//sampleStart
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)
//sampleEnd


    val a =222
    println(a.toString(2))
    val b = a/2
    println(b.toString(2))
    println((a.shr(1)).toString(2))
}

fun main() {
    //sampleStart
    // 静态类型作为浮点数的操作数
    println(Double.NaN == Double.NaN)                 // false
    // 静态类型并非作为浮点数的操作数
    // 所以 NaN 等于它本身
    println(listOf(Double.NaN) == listOf(Double.NaN)) // true

    // 静态类型作为浮点数的操作数
    println(0.0 == -0.0)                              // true
    // 静态类型并非作为浮点数的操作数
    // 所以 -0.0 小于 0.0
    println(listOf(0.0) == listOf(-0.0))              // false

    println(listOf(Double.NaN, Double.POSITIVE_INFINITY, 0.0, -0.0).sorted())
    // [-0.0, 0.0, Infinity, NaN]
    //sampleEnd
}
