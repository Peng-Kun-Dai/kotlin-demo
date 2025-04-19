class Example //

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

open class Base2(val name: String) {
    init {
        println("Initializing a Base2 class")
    }

    open val size: Int = name.length.also {
        println("Initializing a Base2 class:$it")
    }
}

class Derived1(
    name: String,
    val lastName: String,
) : Base2(name.replaceFirstChar { it.uppercase() }.also { println("Argument for Base2 class: $it") }) {
    init {
        println("Initializing a Derived1 class")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing a Derived1 class:$it") }
}

open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            super@FilledRectangle.draw()
            fill()
            println("Drawn a filled rectangle with color $borderColor")
        }
    }

    val fillColor: String get() = super.borderColor
}

open class Rectangle2 {
    open fun draw() { /* ... */
    }
}

interface Polygon2 {
    fun draw() { /* ... */
    } // 接口的成员默认是 'open' 的
}

class Square() : Rectangle2(), Polygon2 {
    // 编译器要求 draw() 方法必须覆盖:
    override fun draw() {
        super<Rectangle2>.draw() // 调用 Rectangle.draw()
        super<Polygon2>.draw() // 调用 Polygon.draw()
    }
}

fun main() {

    /*    //Any class
        val example = Example()
        println(example.hashCode())
        println(example.toString())
        println(example.equals(Example()))*/

//    Derived1("hello", "world")

    val d = FilledRectangle()
    d.draw()
}