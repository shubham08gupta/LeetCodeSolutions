package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/maximum-subarray/description/

// T.C. O(n)
// S.C. O(1)

fun maxSubArray(nums: IntArray): Int {
    // sum till now
    var sum = 0
    // the max sub array sum so far
    var max = Int.MIN_VALUE
    // Kadane's algo
    for (num in nums) {
        sum += num
        max = maxOf(max, sum)
        // don't carry negative sum as it's decreasing the overall sum
        if (sum < 0) {
            sum = 0
        }
    }
    return max
}

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
}