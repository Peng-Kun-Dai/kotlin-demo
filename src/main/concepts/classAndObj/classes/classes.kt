package main.concepts.classAndObj.classes

//主构造函数没有任何注解或者可见性修饰符，constructor可以省略
class Person constructor(firstName: String) {}
class Person2(firstName: String) {}
class Empty

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)
    //.also(::println) //获取对象并打印它
    //在属性初始化时打印日志：可以方便地跟踪初始化过程
    //保持表达式形式：可以在单行表达式内完成初始化和副作用操作
    //不影响原有赋值：.also 会返回原始对象，所以属性最终值不变
    //    .also 和 .let：都接收 lambda，但 .let 返回 lambda 结果
    //    .also 和 .apply：.apply 内部用 this 引用对象，.also 用 it

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

    init {
        println("Initializing customer $customerKey")
    }
}

class Person3 public constructor(
    val firstName: String,
    val lastName: String,
    var age: Int,
    var isEmployed: Boolean = true,
) {
    init {
        println("Init code.")
    }

    constructor() : this("", "", 0) {
        //todo
        println("inner constructor code.")
    }

    constructor(fistName: String) : this(fistName, "", 2) {}
}

class Person4(val pets: MutableList<Pet> = mutableListOf())
class Pet(owner: Person4) {
    init {
        owner.pets.add(this)
    }
}

class Person5(val name: String) {
    val children: MutableList<Person5> = mutableListOf()

    constructor(name: String, parent: Person5) : this(name) {
        println("constructor name is $name")
        println(this)
        parent.children.add(this)
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

class DontCreateMe private constructor() {}

class Customer2(val name: String = "") {}

//特性          |  open          |	abstract
//------------------------------------------------
//类实例化       |  可以直接实例化  |   不能直接实例化
//------------------------------------------------
//成员实现       |  有默认实现     |	无实现，必须由子类实现
//------------------------------------------------
//继承/重写要求   |  可选择是否重写  |	必须重写实现
//------------------------------------------------
//默认修饰       |  需要显式声明	|   自动使成员可重写
//------------------------------------------------
//使用场景       |  提供可选的扩展点 |	定义必须实现的契约


// 可以继承，因为Animal是open的
open class Animal(val name: String) {
    // ...
    open fun speak() {
        println("i am animal")
    }
}

class Dog(name: String) : Animal(name) {
    override fun speak() {
        println("汪汪")
    }
}

//abstract用于定义抽象类和抽象成员，表示不完整的实现，必须由子类提供具体实现。
abstract class Polygon {
    abstract fun draw()
}

class Rectangle : Polygon() {
    override fun draw() {
        //todo
    }
}

abstract class Vehicle {
    abstract val maxSpeed: Int  // 必须由子类实现

    open fun start() {  // 可选重写
        println("Vehicle starting")
    }

    abstract fun stop()  // 必须实现
}

class Car : Vehicle() {
    override val maxSpeed = 200

    override fun start() {
        println("Car starting with ignition")
        super.start()
    }

    override fun stop() {
        println("Car stopping with brakes")
    }
}

class MyClass {
    companion object {
        const val CONSTANT = "constant value"
        fun create(): MyClass = MyClass()
    }
}

fun main() {

    /*    val parent = Person5("jayce")
        println(parent)
        val p = Person5("son", parent)
        println(p)
        println(parent)
        println(parent.children[0])*/
//    println(parent.children[1]) error
//    val p1 = Person5("yvt", p)
//    println(p1.children)


}