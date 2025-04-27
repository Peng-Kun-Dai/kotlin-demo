package main.kotlin.concepts.controlFlow.returns

fun main() {
    outerLoop@ for (i in 1..4) {
        innerLoop@ for (j in 1..4) {
            if (i == 3 && j == 3) break@outerLoop
            println("i=$i, j=$j")
        }
    }
}

fun findFirstDuplicate(matrix: Array<IntArray>, target: Int): Pair<Int, Int>? {
    outer@ for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == target) {
                println("Found at ($i, $j)")
                break@outer
            }
        }
    }
    return null
}

fun processNumbers(numbers: List<Int>) {
    numbers.forEach loop@ {
        if (it < 0) return@loop // 相当于 continue
        println("Processing $it")
    }
}