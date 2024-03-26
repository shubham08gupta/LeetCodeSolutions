package com.example.myapplication.leetcode.binarySearch

// https://leetcode.com/problems/find-peak-element/description/

// T.C. O(log n)
private fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex
    // question says to use O(log n) which means binary search must be used
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] > nums[mid + 1]) {
            // if curr num is greater than the next number, it means that it is smaller
            // (or equal) than the previous number, so the peak must be in the left range. We can
            // be sure of this because the first element is anyways greater than it's left element
            // which is negative infinity
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun main() {
    println(findPeakElement(intArrayOf(1, 2, 3)))
    println(findPeakElement(intArrayOf(-1, -2, -3, -10)))
    println(findPeakElement(intArrayOf(-1)))
    println(findPeakElement(intArrayOf(3, 2, 1, 0)))
    println(findPeakElement(intArrayOf(1, 2)))
}