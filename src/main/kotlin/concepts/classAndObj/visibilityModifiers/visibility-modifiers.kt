package main.kotlin.concepts.classAndObj.visibilityModifiers

private class i1 {}

//protected class i2 {}
internal class i3 {}
public class i4 {}

private fun foo() {
    TODO()
} // 只在 example.kt 文件内可访问

public var bar: Int = 5 // 这个属性在任何地方都可以访问
    private set         // 但它的设值方法只在 example.kt 文件内可以访问

internal val baz = 6    // 在同一个模块(module)内可以访问


//private   表示这个成员只在这个类(以及它的所有成员)之内可以访问.
//protected 表示这个成员的可见度与 private 一样, 但它在子类中也可以访问.
//internal  表示在 本模块之内, 凡是能够访问到这个类的地方, 同时也能访问到这个类的 internal 成员.
//public    表示凡是能够访问到这个类的地方, 同时也能访问这个类的 public 成员.