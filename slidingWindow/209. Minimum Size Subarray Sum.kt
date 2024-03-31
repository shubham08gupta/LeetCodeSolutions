package com.example.myapplication.leetcode.slidingWindow

// https://leetcode.com/problems/minimum-size-subarray-sum/description/

// T.C. O(n)
// S.C. O(1)
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var length = Int.MAX_VALUE
    var l = 0
    var sum = 0

    // use sliding window approach
    for (r in 0..nums.lastIndex) {
        // current window sum
        sum += nums[r]

        // keep checking that whether decreasing the window size is still valuable or not
        while (sum >= target) {
            length = minOf(r - l + 1, length)
            // reduce the window
            sum -= nums[l]
            l++
        }
    }

    return if (length == Int.MAX_VALUE) {
        0
    } else {
        length
    }
}

fun main() {
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(minSubArrayLen(4, intArrayOf(1, 4, 4)))
    println(minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
}