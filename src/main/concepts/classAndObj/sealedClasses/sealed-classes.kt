package main.concepts.classAndObj.sealedClasses

import java.io.File
import javax.sql.DataSource

//受限继承：所有子类必须与封闭类在同一个文件中声明（Kotlin 1.5 后放宽了此限制）
//抽象性：默认是抽象的，不能直接实例化
//完备性：与 when 表达式配合使用时，编译器可以检查是否覆盖了所有情况

sealed interface Error

object RuntimeError : Error
sealed class IOError() : Error

class FileReadError(val file: File) : IOError() //不能被再次继承
class DatabaseError(val source: DataSource) : IOError()


// 这个示例可以代表一个库的 API, 其中包含很多错误类, 以便类的使用者能够处理库可能抛出的错误.
// 如果这些错误类的继承层级包含在公开 API 可见的接口或抽象类, 那么就不能禁止其他开发者在他们的代码中实现这些接口或扩展这些抽象类.
// 由于库不知道在它外部定义的错误类, 因此库不能象它自己定义的类那样一致的处理这些外部定义的类.
// 如果将错误类的继承阶层封闭起来, 库的作者就能够确定的知道所有可能的错误类型, 并且能够确定以后不会出现其他错误类型.
// 但是, 使用 封闭的 错误类层级结构, 库的作者就能够确定他们知道了所有可能的错误类型, 而且之后也不会出现其他的错误类型.

sealed class Error1(val message: String) {
    class NetworkError : Error1("Network failure: ")
    class DatabaseError : Error1("Database cannot be reached")
    class UnknownError : Error1("An unknown error has occurred")
}

enum class ErrorSeverity {
    MINOR,
    MAJOR,
    CRITICAL
}

sealed class Error2(val severity: ErrorSeverity) {
    class FileReadError(val file: File) : Error2(ErrorSeverity.MAJOR)
    class DatabaseError(val source: DataSource) : Error2(ErrorSeverity.CRITICAL)
    object RuntimeError : Error2(ErrorSeverity.CRITICAL)
}

sealed class IOError1 {
    // 封闭类的构造器默认可见度为 protected. 构造器在这个类和它的子类中可见.
    constructor() {
        TODO()
    }

    // private 构造器, 只在这个类中可见.
    // 在封闭类中使用 private 构造器, 可以更加严格的控制实例的创建, 实现类中特定的初始化过程.
    private constructor(description: String) : this() {
        TODO()
    }
}

sealed interface Error3

// 枚举类扩展封闭接口 'Error'
enum class ErrorType : Error3 {
    FILE_ERROR,
    DATABASE_ERROR
}

sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: String) : UIState()
    data class Error(val exception: Exception) : UIState()
}

fun updateUI(state: UIState) {
//    when (state) {
//        is UIState.Loading -> showLoadingIndicator()
//        is UIState.Success -> showData(state.data)
//        is UIState.Error -> showError(state.exception)
//    }
}

sealed class Payment {
    data class CreditCard(val number: String, val expiryDate: String) : Payment()
    data class PayPal(val email: String) : Payment()
    data object Cash : Payment()
}

fun processPayment(payment: Payment) {
//    when (payment) {
//        is Payment.CreditCard -> processCreditCardPayment(payment.number, payment.expiryDate)
//        is Payment.PayPal -> processPayPalPayment(payment.email)
//        is Payment.Cash -> processCashPayment()
//    }
}

fun main() {
    val errors = listOf(Error1.NetworkError(), Error1.DatabaseError(), Error1.UnknownError())
    errors.forEach {
        println(it.message)
    }


}