package main.kotlin.concepts.classAndObj.classes

//主构造函数没有任何注解或者可见性修饰符，constructor可以省略
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
class Pet {
    constructor(owner: Person4) {
        owner.pets.add(this)
    }
}

class Person5(val name: String) {
    val children: MutableList<Person5> = mutableListOf()

    constructor(name: String, parent: Person5) : this(name) {
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


fun main() {
//    Person3("jayce", "D", 20)
//    Person3("")

    Animal("jayce") //success
    //Polygon()//fail
    val d = Dog("1")
    d.speak()

    val v = Car()
    v.start()
    v.stop()

    val ca = MyClass
}
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
//    override fun speak() {
//        println("汪汪")
//    }
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