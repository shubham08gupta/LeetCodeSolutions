package com.example.myapplication.leetcode.binarySearch

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
private fun shipWithinDays(weights: IntArray, days: Int): Int {
    var left = weights.max() // bcoz ship needs to carry all weights
    var right = weights.sum() // bcoz ship's weight can be as large as possible
    while (left < right) {
        val mid = left + (right - left) / 2
        if (condition(weights, days, mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun condition(weights: IntArray, days: Int, min: Int): Boolean {
    var d = 1
    var sum = 0 // calculate how many weights can be taken in a single day d
    for (weight in weights) {
        if (sum + weight > min) {
            // cannot take this much weight so need an extra day
            d++
            sum = weight
        } else {
            sum += weight
        }
    }

    return d <= days
}


fun main() {
    val arr1 = intArrayOf(3, 2, 2, 4, 1, 4)
    println(shipWithinDays(arr1, 3))

    val arr2 = intArrayOf(1, 2, 3, 1, 1)
    println(shipWithinDays(arr2, 4))

    val arr3 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(shipWithinDays(arr3, 5))
}