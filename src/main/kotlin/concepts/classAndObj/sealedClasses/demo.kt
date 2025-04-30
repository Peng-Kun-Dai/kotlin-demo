package main.kotlin.concepts.classAndObj.sealedClasses

// 引入必须的模块
import io.ktor.server.application.*
import io.ktor.server.resources.*

import kotlinx.serialization.*

// 定义封闭接口, 表示使用 Ktor 资源的 API 请求
@Resource("api")
sealed interface ApiRequest

@Serializable
@Resource("login")
data class LoginRequest(val username: String, val password: String) : ApiRequest

@Serializable
@Resource("logout")
object LogoutRequest : ApiRequest

// 定义封闭类 ApiResponse, 包括具体的应答类型
sealed class ApiResponse {
    data class UserSuccess(val user: UserData) : ApiResponse()
    data object UserNotFound : ApiResponse()
    data class Error(val message: String) : ApiResponse()
}

// 用户数据类, 在成功应答中使用
data class UserData(val userId: String, val name: String, val email: String)

// 这个函数校验用户凭证 (只为演示用)
fun isValidUser(username: String, password: String): Boolean {
    // 使用固定的校验逻辑 (这只是一段演示代码)
    return username == "validUser" && password == "validPass"
}

// 这个函数使用具体的应答来处理 API 请求
fun handleRequest(request: ApiRequest): ApiResponse {
    return when (request) {
        is LoginRequest -> {
            if (isValidUser(request.username, request.password)) {
                ApiResponse.UserSuccess(UserData("userId", "userName", "userEmail"))
            } else {
                ApiResponse.Error("Invalid username or password")
            }
        }
        is LogoutRequest -> {
            // 这个示例假设 logout 操作永远成功
            ApiResponse.UserSuccess(UserData("userId", "userName", "userEmail")) // 演示用
        }
    }
}

// 这个函数模拟一个 getUserById 调用
fun getUserById(userId: String): ApiResponse {
    return if (userId == "validUserId") {
        ApiResponse.UserSuccess(UserData("validUserId", "John Doe", "john@example.com"))
    } else {
        ApiResponse.UserNotFound
    }
    // 错误处理也会生成错误应答.
}

// 主函数, 演示使用方法
fun main() {
    val loginResponse = handleRequest(LoginRequest("user", "pass"))
    println(loginResponse)

    val logoutResponse = handleRequest(LogoutRequest)
    println(logoutResponse)

    val userResponse = getUserById("validUserId")
    println(userResponse)

    val userNotFoundResponse = getUserById("invalidId")
    println(userNotFoundResponse)
}