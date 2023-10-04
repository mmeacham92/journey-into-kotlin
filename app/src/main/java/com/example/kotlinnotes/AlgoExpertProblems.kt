package com.example.kotlinnotes

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    // loop through array
    // a + b = targetSum, therefore targetSum - a = b
    // create a set to hold previously seen values
    // as we loop through the array, find b
    // if b isn't in the set, add the current value to the set
    // if b is in the set, return [current, b]
    // if we get to the end of the array, return []

    val seenNumbers = mutableSetOf<Int>()

    for (number in array) {
        if (seenNumbers.contains(targetSum - number)) return listOf(number, targetSum - number)
        seenNumbers.add(number)
    }
    return listOf()
}