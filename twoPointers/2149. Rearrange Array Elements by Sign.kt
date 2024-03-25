package com.example.myapplication.leetcode.twoPointers

// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

// T.C. O(n)
private fun rearrangeArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    var p = 0 // pointer for positive nums
    var n = 1 // pointer for negative nums
    for (num in nums) {
        if (num > 0) {
            ans[p] = num
            p += 2
        } else {
            ans[n] = num
            n += 2
        }
    }
    return ans
}

fun main() {
    println(rearrangeArray(intArrayOf(3, 1, -2, -5, 2, -4)).joinToString())
    println(rearrangeArray(intArrayOf(-1, 1)).joinToString())
    println(rearrangeArray(intArrayOf(1, -1)).joinToString())
}


