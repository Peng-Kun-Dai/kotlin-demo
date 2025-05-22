package example.concepts.classAndObj.nestedClasses

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }

    inner class Inner {
        fun foo() = bar
    }
}

interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}

fun main() {
    val demo = Outer.Nested().foo()     //类名访问
    val demo2 = Outer().Inner().foo()   //对象访问
}

//window.addMouseListener(object:MouseAdapter(){
//    override fun mouseClicked(e: MouseEvent) {
//        TODO()
//    }
//})