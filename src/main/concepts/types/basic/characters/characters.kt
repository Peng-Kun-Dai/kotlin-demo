package main.concepts.types.basic.characters

fun main() {
    //sampleStart
    val aChar: Char = 'a'

    println("a\ta")
    println("a\ba")
    println("a\na")
    println("a\ra")
    println("a\'a")
    println("a\"a")
    println("a\\a")
    println("a\$a")
    println("aa")
    println("aa")
    println("aa")
    println("\uFF00")

    println('1'.digitToInt())
    println('9'.digitToInt())
//sampleEnd
}