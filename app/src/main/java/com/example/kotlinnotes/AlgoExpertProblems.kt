package com.example.kotlinnotes

import kotlin.math.abs

// -----------------------------------------------------------
// completed: work in progress... trying to find the right method to handle potential nulls
fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    // Write your code here.
    var scoreMap = mutableMapOf<String, Int>()
    for (i in results.indices) {
        // use results[i] to determine who won from competitions
        var currentMatch = competitions[i]
        var positionOfWinner = results[i]
        var winner = competitions[i][currentMatch.size - 1 - positionOfWinner]

        if (scoreMap.containsKey(winner)) {
            var currentScore = scoreMap[winner] ?: 0
            var newScore = currentScore + 3
            scoreMap[winner] = newScore
        } else scoreMap[winner] = 0
    }

    var winningTeam = ""
    var winningScore = 0
    for (key in scoreMap.keys) {
        if (scoreMap[key]!! > winningScore) {
            winningTeam = key
            winningScore = scoreMap[key]!!
        }
    }

    return winningTeam
}

// -----------------------------------------------------------
// completed: 10/8/2023
fun sortedSquaredArray(array: List<Int>): List<Int> {
    // Write your code here.
    // the naive approach would be to create a new list, fill it with the square of each element
    //  from the original list, then sort the new list. This would be O(nlogn) time and O(n) space
    //  but we can do better in regards to time complexity

    // in order to save time, we can place each element in the correct spot in the new list immediately
    // to do so, we need to keep track of the where the smallest and largest numbers are
    // since we know the original list is sorted in ascending order, the element furthest left will
    // always be the smallest remaining integer and the likewise for the element nearest to the end
    // because negatives become positive when squaring, we can compare the absolute values of the
    //   smallest and largest values

    // first we'll create a mutable list to store our sorted squares and two index variables to
    //   represent where the smallest and largest numbers are currently
    // we'll loop array.length times, each iteration we'll compare the absolute values of the smallest
    //   and largest values. once the larger absolute value is determined, we select that number to
    //   square and add it to the BEGINNING of the new list. new values will always be added to the BEGINNING
    //   since we are looking for which of two values have a LARGER absolute value (bigger numbers go in first)

    val sortedSquares = mutableListOf<Int>()
    var smallIndex = 0
    var largeIndex = array.size - 1
    // 10/14/2023
    // Recently learned about the array.indices property which is a much more elegant approach than using i in 0..array.size-1
    for (i in array.indices) {
        // 10/14/2023
        // Reviewed my past solution and realized I could use idiomatic Kotlin here instead of a "regular" if-else block
        val numberToSquare = if (abs(array[smallIndex]) > abs(array[largeIndex])) array[smallIndex++]
        else array[largeIndex--]

        sortedSquares.add(0, numberToSquare * numberToSquare)

        // In Kotlin the static Math method pow only accepts doubles? vvvv
        // sortedSquares.add(0, Math.pow(numberToSquare.toDouble(), 2.0).toInt())
    }

    return sortedSquares
}

// -----------------------------------------------------------
// completed: 10/7/2023
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
        if (number == sequence[sequenceIndex]) sequenceIndex += 1
        if (sequenceIndex == sequence.size) return true
    }
    return false
}

// -----------------------------------------------------------
// completed: 10/4/2023
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