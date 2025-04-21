package org.example.demo.type

fun main() {
    var myTrue: Boolean = true
    var myFalse: Boolean = false
    var boolNull: Boolean? = null

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)
    println(boolNull)
}