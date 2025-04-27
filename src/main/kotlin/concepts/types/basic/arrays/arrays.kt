package main.kotlin.concepts.types.basic.arrays
// 使用对象类型数组 - 有装箱开销
/*
这会带来以下开销：
额外的内存分配（每个值都是一个独立对象）
内存访问开销（需要通过引用访问）
可能的GC压力（产生更多短期对象）
* */
val boxedArray: Array<Int> = arrayOf(1, 2, 3) // 每个Int被装箱

// 使用原生类型数组 - 无装箱开销
val primitiveArray: IntArray = intArrayOf(1, 2, 3) // 直接存储int值

/*
何时使用哪种
使用原生类型数组(IntArray等)：
处理大量数值数据
性能敏感的场景
不需要存储null值

使用对象类型数组(Array<Int>等)：
需要存储null值(Array<Int?>)
需要与其他泛型代码交互
数据量不大，性能不是关键因素

底层实现
在JVM上：
IntArray编译为int[]
Array<Int>编译为Integer[]
*/

/*
* 与数组相比，集合具有以下优点：

集合可以是只读的，这提供了更多的控制权而支持编写具有明确意图的健壮代码。
易于对集合增删元素。相比之下，数组大小是固定的。 对数组增删元素的唯一方式是每次创建一个新数组，效率很低：
可以使用相等操作符（==）来检验两个集合是否在结构上相等。但不能对数组使用这个操作符。 相反，必须使用一个特殊函数，关于这点可以参阅比较数组了解更多信息。
* */

fun main5() {
    val simpleArray = arrayOf(1, 2, 3)
    println(simpleArray.joinToString())

    val nullArray: Array<Int?> = arrayOfNulls(3)
    println(nullArray.joinToString())

    val exampleArray: Array<String> = emptyArray<String>()
    println(exampleArray.joinToString())
}

fun main6() {
    //sampleStart
    // Creates an Array<Int> that initializes with zeros [0, 0, 0]
    val initArray = Array<Int>(3) { 0 }
    println(initArray.joinToString())
    // 0, 0, 0

    // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { print(it) }
    // 014916
//sampleEnd
}

fun main7() {
    //sampleStart
    // Creates a two-dimensional array
    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
    println(twoDArray.contentDeepToString())
    // [[0, 0], [0, 0]]

    // Creates a three-dimensional array
    val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }
    println(threeDArray.contentDeepToString())
    // [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]
//sampleEnd
}

fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}

fun main8() {
//    val simpleArray = arrayOf(1, 2, 3)
    val simpleArray = arrayOf(arrayOf(1, 23), 2, 3)
    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
//    simpleArray[0] = 10
    twoDArray[0][0] = 2
    println(simpleArray.contentDeepToString())
    println(twoDArray.contentDeepToString())

    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray)
    // abcd
}

fun main9() {
    //sampleStart
    val simpleArray = arrayOf(1, 2, 3)
    val anotherArray = arrayOf(1, 2, 3)

    //Compares contents of arrays
    println(simpleArray.equals(anotherArray))
    println(simpleArray.contentEquals(anotherArray))
    simpleArray[0] = 10
    println(simpleArray.contentEquals(anotherArray))

}

fun main10() {
    //sampleStart
    val sumArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // Sums array elements
    println(sumArray.sum())
    // 45
    sumArray.shuffle()
    println(sumArray.contentToString())
    sumArray.shuffle()
    println(sumArray.contentToString())

    val simpleArray = arrayOf("a", "b", "c", "c")
    // Converts to a Set
    println(simpleArray.toSet())
    // [a, b, c]

    // Converts to a List
    println(simpleArray.toList())
    // [a, b, c, c]


    val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)
    println(pairArray.contentToString())
    // Converts to a Map
    println(pairArray.toMap())
    // [a, b, c, c]
//sampleEnd
}

fun main() {
    //原生类型数组
    val exampleArray = IntArray(5)
    println(exampleArray.contentToString())

    //原生数组转对象数组
    val x = exampleArray.toTypedArray()
    //对象数组转原生数组
    val y = x.toIntArray()
    println(exampleArray.equals(y))

    val i1: BooleanArray
    val i3: CharArray
    val i5: FloatArray
    val i4: DoubleArray
    val i2: ByteArray
    val i6: IntArray
    val i7: ShortArray
    val i8: LongArray
}
