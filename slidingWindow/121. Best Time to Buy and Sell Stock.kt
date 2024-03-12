package com.example.myapplication.leetcode.slidingWindow

import kotlin.math.max

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

fun maxProfit(prices: IntArray): Int {
    var max = 0
    var l = 0
    var r = 1
    while (r <= prices.lastIndex) {
        val currProfit = prices[r] - prices[l]
        if (currProfit > 0) {
            max = max(max, currProfit)
        } else {
            l = r
        }
        r++
    }

    return max
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))
}