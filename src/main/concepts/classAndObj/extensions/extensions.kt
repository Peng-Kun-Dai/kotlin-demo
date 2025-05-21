package main.concepts.classAndObj.extensions

//Kotlin 提供了向一个类或一个接口扩展新功能的能力, 而且不必从这个类继承, 也不必使用 装饰器(Decorator) 之类的设计模式.


fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

open class Shape {
    fun getName(): String {
        return "Shape getName()"
    }
}

class Rectangle : Shape()

fun Shape.getName(empty: Int?) = "Shape"
fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName(null))
}

//可为空的接收者
fun Any?.toString(): String {
    if (this == null) return "null"
    return this.toString()
}

val <T> List<T>.lastIndex: Int
    get() = size - 1
//val House.number = 1 // 错误: 扩展属性不允许存在初始化器

class MyClass {
    companion object {}
}

fun MyClass.Companion.printCompanion() {
    println("Companion")
}


class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }

    fun prtInfo() {
        println(hostname)
    }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() {
        println(port)
    }

    fun Host.printConnectionString() {
        //屎山设计
        printHostname()   // 这里会调用 Host.printHostname()
        print(":")
        printPort()   // 这里会调用 Connection.printPort()

        prtInfo()
        this@Connection.prtInfo()
    }

    fun connect() {/*...*/
        host.printConnectionString()   // 这里会调用扩展函数
    }

    fun prtInfo() {
        println(host.hostname + port.toString())
    }
}

fun main() {
    printClassName(Rectangle()) //Shape

    MyClass.printCompanion()

    Connection(Host("kotl.in"), 443).connect()

    BaseCaller().call(Base())   // 输出结果为 "Base extension function in BaseCaller"
    DerivedCaller().call(Base())  // 输出结果为 "Base extension function in DerivedCaller" - 派发接受者的解析过程是虚拟的
    DerivedCaller().call(Derived())  // 输出结果为 "Base extension function in DerivedCaller" - 扩展接受者的解析过程是静态的
}

open class Base {}
class Derived : Base() {}
open class BaseCaller {
    open fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunctionInfo()
    }
}

class DerivedCaller : BaseCaller() {
    override fun Base.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}