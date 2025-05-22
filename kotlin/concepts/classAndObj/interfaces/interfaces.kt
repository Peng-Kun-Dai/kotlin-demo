package example.concepts.classAndObj.interfaces

import javax.swing.text.Position

//Kotlin 中的接口可以包含抽象方法的声明, 也可以包含方法的实现.
// 接口与抽象类的区别在于, 接口不能存储状态数据. 接口可以有属性, 但这些属性必须是抽象的, 或者必须提供访问器的自定义实现.
interface MyInterface {
    val prop: Int //抽象属性
    val propertyWithImplementation: String
        get() = "foo"

    fun bar()
    fun foo() {
        println(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 42
    override fun bar() {}
    override fun foo() {
        super.foo()
        println(prop)
    }
}

interface Named {
    val name: String
}

interface Person6 : Named {
    val firstName: String
    val lastName: String
    override val name: String get() = "$firstName $lastName"
}

data class Employee(override val firstName: String, override val lastName: String, val position: Position) : Person6

interface A {
    fun foo() {
        println("A")
    }

    fun bar()
}

interface B {
    fun foo() {
        println("B")
    }

    fun bar() {
        println("bar")
    }
}

class C : A {
    override fun bar() {
        println("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}

fun main() {
    val d = D()
    d.foo()
    d.bar()
}