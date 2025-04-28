package main.kotlin.concepts.classAndObj.properties

class Address {
    var name: String = "Holmes,Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street
    result.city = address.city
    result.state = address.state
    result.zip = address.zip
    return result
}

class Rectangle(val width: Int, val height: Int) {
    val area: Int
        get() = this.width * this.height
    var stringRepresentation: String
        get() = this.toString()
        set(value) {
//            setDataFromString(value)
        }
    var setterVisibility: String = "abc"
        private set
    var setterWithAnnotation: Any? = null

    //        @Inject set
    var counter = 0
        set(value) {
            if (value >= 0) field = value
        }
//    val isEmpty: Boolean
//        get() = this.size == 0
}

const val SUBSYSTEM_DEPRECATED: String = "Subsystem Deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() {
    TODO()
}
//
//public class MyTest {
//    lateinit var subject: TestSubject
//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()
//    }
//}

fun main() {
    var initialized = 1
    val simple: Int?
    val inferredType = 1

    val r = Rectangle(1, 1)
    r.counter = -3
    println(r.counter)
    r.counter = 3
    println(r.counter)
}