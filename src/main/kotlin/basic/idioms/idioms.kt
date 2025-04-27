package main.kotlin.basic.idioms

import java.io.File
import java.math.BigDecimal

data class Customer(val name: String = "", val age: Int = 0) {
    val info: String by lazy {
        "$name - $age"
    }
}


fun main() {
    val customer = Customer("jayce", 28)
    println(customer.hashCode())
    println(customer.toString())
    println(customer.equals(customer.copy()))
    println(customer.component1())
    println(customer.component2())
//    println(customer.component3())

    val list = arrayListOf(-4, -3, -2, 1, 2, 3, 4, 5)
    val positives = list.filter { it > 0 }
    println(positives.toString())

    if (4 in list) {
        println("i'm exist.")
    }

//    val wrongInt = readln().toIntOrNull()
//    println(wrongInt)

    val list2 = listOf("a", "b", "c")

    val map = mutableMapOf("a" to 1, "b" to 2, "c" to 3, "key" to null)
    println(map["key"])
    map["key"] = 123
    println(map["key"])
    for ((key, value) in map) {
        println("$key -> $value")
    }

    for (i in 100 downTo 0 step 10) {
        println(i)
    }
    (1..10).forEach {
        println(it)
    }
    println(customer.info)

    "Convert this to camelcase".spaceToCamelCase()

    val file = File("Test").listFiles()

    println(file?.size) //if not null
    println(file?.size ?: "empty") //if not null else
    val emails: ArrayList<String> = ArrayList()
    val emailList = emails.firstOrNull() ?: ""
    file?.let {
        println(it)
    }

    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    var a1 = 1
    var b1 = 2
    a1 = b1.also { b1 = a1 }
}

class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(degrees: Double) {}
}

fun String.spaceToCamelCase() {
    println(this.uppercase())
}

object Resource {
    val name = "Name"
}

@JvmInline
value class EmployeeId(private val id: Int)

@JvmInline
value class CustomerId(private val id: EmployeeId)

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 0
        else -> throw IllegalArgumentException("Unknown color")
    }
}

fun test() {
    val result = try {
//        count()
    } catch (e: ArithmeticException) {
        throw IllegalArgumentException(e)
    }
}

fun foo(param: Int) {
    val result = if (param == 1) {
        "one"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun calcTaxes(): BigDecimal = TODO("waiting  for feedback from accounting")