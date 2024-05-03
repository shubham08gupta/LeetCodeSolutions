package com.example.myapplication.leetcode.heap

// https://leetcode.com/problems/kth-largest-element-in-an-array/

// T.C. avg case O(n); worst case O(n ^ 2)
// S.C. O(1)

/**
 * There are minimum 2 solutions to this problems- one is using heap and another using Quick Select
 * I've used Quick Select as it's less common
 */
private fun findKthLargest(nums: IntArray, k: Int): Int {


    // partition the array such that the pivot element is sorted
    fun findPivotIndex(start: Int, end: Int): Int {

        fun swap(a: IntArray, p: Int, q: Int) {
            val temp = a[p]
            a[p] = a[q]
            a[q] = temp
        }

        val pivot = nums[end]
        var pivotIndex = start
        for (i in start..end) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotIndex)
                pivotIndex++
            }
        }

        swap(nums, pivotIndex, end)
        return pivotIndex
    }


    // continuously check if we've found our Kth largest element
    fun quickSelect(start: Int, end: Int, K: Int): Int {
        val pivotIndex = findPivotIndex(start, end)
        return if (pivotIndex < K) {
            // go to right side
            quickSelect(pivotIndex + 1, end, K)
        } else if (pivotIndex > K) {
            // go to left side
            quickSelect(start, pivotIndex - 1, K)
        } else {
            nums[pivotIndex]
        }
    }

    // want the "largest" element (not smaller)
    val K = nums.size - k

    return quickSelect(0, nums.lastIndex, K)
}


fun main() {
    println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}