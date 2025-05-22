package example.basic.syntax


fun main(args: Array<String>) {
    println("hello world")
    println(args.contentToString())

    println(sum(3, 5))
    println("sum of 19 and 23 is ${sum(19, 23)}")

    /* // 打印消息, 要求用户输入
     println("Enter any word: ")

     // 读取并保存用户的输入. 例如: Happiness
     val yourWord = readln()

     // 将用户的输入和一个消息一起打印输出
     print("You entered the word: ")
     print(yourWord)
     // 输出结果为 You entered the word: Happiness

     val rectangle = Rectangle(5.0, 2.0)
     println("this perimeter is ${rectangle.perimeter}")*/


    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
        println("${list.lastIndex}") //2
        println("${list.indices}")  //0..2
        println("${list.size}")  //3
    }
    if (list.size !in list.indices) {
        println("list size is out of valid range")
    }


    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

class Shape

class Rectangle(val height: Double, val length: Double) {
    val perimeter: Double = (height + length) * 2
}


fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "Unknown"
}
