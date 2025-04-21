package org.example.demo.classes

data class User(val name: String, var age: Int)

fun main(){
    val user1 = User("Alice", 29)

    val user2 = user1.copy("Bob")
    println(user1.equals(user2))
}
