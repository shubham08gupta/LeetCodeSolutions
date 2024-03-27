package com.example.myapplication.leetcode.twoPointers

// https://leetcode.com/problems/sort-colors/
private fun sortColors(nums: IntArray) {
    // left pointer has all 0s on it's left side
    var l = 0
    var curr = 0
    // right pointer has all 2s on it's right side
    var r = nums.lastIndex
    // minimize the gap so that all 1s are in b/w l and r
    while (curr <= r) {
        when (nums[curr]) {
            0 -> {
                swap(nums, l, curr)
                l++
                curr++
            }

            1 -> {
                curr++
            }

            2 -> {
                swap(nums, r, curr)
                r--
            }

        }
    }

}

private fun swap(nums: IntArray, index1: Int, index2: Int) {
    val temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp
}

fun main() {
    intArrayOf(2, 0, 2, 1, 1, 0).apply { sortColors(this) }.also { println(it.joinToString()) }
    intArrayOf(2, 0, 1).apply { sortColors(this) }.also { println(it.joinToString()) }
}