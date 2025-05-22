package example.concepts.classAndObj.dataClasses

data class User(val name: String, var age: Int)

data class Person(val name: String) {
    var age: Int = 0
}

fun main() {
    val user1 = User("Alice", 29)

    val user2 = user1.copy("Bob")
    println(user1.equals(user2))
    println(user1.hashCode())
    println(user2.hashCode())
    println(user1.toString())
    println(user1.component1())
    println(user1.component2())

    val person1 = Person("Dmitry")
    val person2 = Person("John")
    person1.age = 10
    person2.age = 20
    println("person1 == person2: ${person1 == person2}")
    // 输出结果为 person1 == person2: true
    println("person1 with age ${person1.age}: ${person1}")
    // 输出结果为 person1 with age 10: Person(name=John)
    println("person2 with age ${person2.age}: ${person2}")
    // 输出结果为 person2 with age 20: Person(name=John)

    val user3 = user1.copy(age = 18)
    println(user3)
    val (name, age) = user3
    println("$name, $age years of age")
}
