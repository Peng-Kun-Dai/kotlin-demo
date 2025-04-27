package main.kotlin.demo

fun main() {
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps);
    println("Walking $steps steps burns $caloriesBurned calories")

    println("Use the val keyword when the value doesn't change.")
    println("Use the var keyword when the value can change.")
    println("When you define a function, you define the parameters that can be passed to it.")
    println("When you call a function, you pass arguments for the parameters.")
    println("New chat message from a friend")
}

fun pedometerStepsToCalories(numberOfStepS: Int): Double {
    val caloriesBurnedForEachStep = 0.04
    val totalCaloriesBurned = numberOfStepS * caloriesBurnedForEachStep
    return totalCaloriesBurned
}

fun compare(today: Int, yesterday: Int): Boolean {
    return today > yesterday
}

fun pr(city: String, low: Int, high: Int, rain: Int) {
    println("City $city")
    println("Low temperature: $low, High temperature: $high")
    println("Chance of rain: $rain%")
    println()
}
