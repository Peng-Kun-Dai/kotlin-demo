package main.concepts.functions.function

fun double(x: Int) = x * 2


fun powerOf(
    number: Int, exponent: Int
): Int {
    /**
     *
     */
    return number * exponent
}

fun read(
    b: ByteArray,
    off: Int = 0,
    len: Int = b.size,
) {
    /**
     *
     */

}

open class A {
    open fun foo(i: Int = 10) {}
    open fun bar(i: Int) {}
}

class B : A() {
    override fun foo(i: Int) {
        println("i value is $i")
    }

    override fun bar(i: Int) {
        println("i value is $i")
    }
}

fun foo(
    bar: Int = 0,
    baz: Int,
) { /*...*/
    println("this is foo1.")
    println(bar)
    println(baz)
}

fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit,
) { /*...*/
    println("this is foo2.")
    println(bar)
    println(baz)
    println(qux)
}

fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' ',
) { /*...*/
    println("-----------------------------------")
    println("str is $str")
    println("normalizeCase is $normalizeCase")
    println("upperCaseFirstLetter is $upperCaseFirstLetter")
    println("divideByCamelHumps is $divideByCamelHumps")
    println("wordSeparator is $wordSeparator")
}

fun foo(vararg bs: String) {
    println(bs.joinToString("-"))
}

fun printHello(name: String?): Unit {
    if (name != null) {
        println("Hello $name")
    } else {
        println("Hi there!")
    }
}

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) result.add(t)
    return result
}


fun main() {
//    val result = double(2)
//    println(result)
//
//    B().foo()
//    B().bar(3)

//    foo(baz = 1) // 这里将会使用默认参数 bar = 0
//    foo(1) { println("hello") }     // 这里将会使用默认参数 baz = 1
//    foo(qux = { println("hello") }) // 这里将会使用默认参数 bar = 0 和 baz = 1
//    foo { println("hello") }        // 这里将会使用默认参数 bar = 0 和 baz = 1


//    reformat(
//        "String!", false, upperCaseFirstLetter = false, divideByCamelHumps = true, '_'
//    )
//    reformat("this is a long String.")
//    reformat("This is a short String!", upperCaseFirstLetter = false, wordSeparator = '_')

//    foo(bs = arrayOf("a", "b", "c"))

    println(asList("hello", "world", ""))
    println(asList(1, 2, 3))
}