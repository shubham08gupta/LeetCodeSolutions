package com.example.myapplication.leetcode.binarySearch

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

// O(n * log m) where m is the count of numbers b/w l and r
private fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
    // some test cases have huge inputs
    val product: Long = m.toLong() * k.toLong()
    if (product > bloomDay.size) return -1

    var l = bloomDay.min() // at least these many days are required
    var r = bloomDay.max() // maximum these many days can be possible
    while (l < r) {
        val mid = l + (r - l) / 2
        if (isPossible(bloomDay, m, k, mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    return l
}

// O(n)
private fun isPossible(bloomDay: IntArray, m: Int, k: Int, minDays: Int): Boolean {
    var bouquets = 0
    var adjacentFlowersCount = 0 // count how many adjacent flowers can be taken at once
    for (day in bloomDay) {
        if (day <= minDays) {
            adjacentFlowersCount++
        } else {
            adjacentFlowersCount = 0
        }
        // if we have taken all the adjacent flowers, we have a new bouquet
        if (adjacentFlowersCount == k) {
            bouquets++
            adjacentFlowersCount = 0 // start search for a new bouquet
        }
    }
    return bouquets >= m
}

fun main() {
    val arr1 = intArrayOf(1, 10, 3, 10, 2)
    println(minDays(arr1, 3, 1))

    val arr2 = intArrayOf(1, 10, 3, 10, 2)
    println(minDays(arr2, 3, 2))

    val arr3 = intArrayOf(7, 7, 7, 7, 12, 7, 7)
    println(minDays(arr3, 2, 3))
}