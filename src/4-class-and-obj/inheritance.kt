class Example //

fun main() {

    //Any class
    val example = Example()
    println(example.hashCode())
    println(example.toString())
    println(example.equals(Example()))
}

open class Base(p: Int) {}

class Derived(p: Int) : Base(p) {}


open class Shape {
    open val vertexCount: Int = 0
    open fun draw() {}
    fun fill() {}
}

open class Circle() : Shape() {
    override val vertexCount: Int
        get() = super.vertexCount + 1

    override fun draw() {}
    //禁止再次覆盖
//    final override fun draw(){}
}

class Circle2() : Circle() {
    override fun draw() {}
}


