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


fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    // Write your code here.
    // we will loop through the array, but first
    // create a position variable for the sequence
    // position will start at the beginning (index 0) of the sequence
    // as we loop through the array, we check if the current element in array is the element at
    //   sequence[position]
    // if we find a match, we increment position
    // if position is ever equal to sequence.length, we'll know that the array contains the
    //  sequence

    var sequenceIndex: Int = 0
    for (number: Int in array) {
        if (number === sequence[sequenceIndex]) sequenceIndex += 1
        if (sequenceIndex === sequence.size) return true
    }
    return false
}