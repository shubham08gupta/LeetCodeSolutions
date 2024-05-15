package com.example.myapplication.leetcode.binarySearch

private fun searchRange(nums: IntArray, target: Int): IntArray {
    // simple binary search
    fun firstGreaterOrEqual(target: Int): Int {
        var left = 0
        var right = nums.size // note this
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    val start = firstGreaterOrEqual(target)
    if (start == nums.size || nums[start] != target) {
        return intArrayOf(-1, -1)
    }
    // find target + 1, and subtract the position by 1 so that we do not find the same target again
    return intArrayOf(start, firstGreaterOrEqual(target + 1) - 1)
}

private fun IntArray.printArray() {
    if (isEmpty()) return

    for (item in this) {
        print("$item, ")
    }
    println()
}

fun main() {
    searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).printArray()
    searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).printArray()
    searchRange(intArrayOf(), 0).printArray()
}