package main.concepts.types.typecasts

fun ex(x: Any) {/*    if (obj is String) {
            print(obj.length)
        }
        if (obj !is String) {
            print("Not a string")
        } else {
            print(obj.length)
        }*/
    // `||` 右侧的 x 自动转换为 String
    if (x !is String || x.length == 0) return

    // `&&` 右侧的 x 自动转换为 String
    if (x is String && x.length > 0) {
        print(x.length) // x 自动转换为 String
    }
}

fun demo(x: Any) {
    when (x) {
        is Int -> print(x + 1) //any to int
        is String -> print(x + "------")
        is IntArray -> print(x.sum())
    }
}

fun main() {
    ex(1)
    val y = null
    val x: String? = y as String?
}