//constructor可以省略
class Person constructor(firstName: String) {}
class Person2(firstName: String) {}
class Empty

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}


class Customer(name: String) {
    val customerKey = name.toUpperCase()
    init{
        println("Initializing customer $customerKey")
    }
}

fun main() {
    InitOrderDemo("Hello")
    Customer("Hello")
}