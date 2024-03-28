package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/missing-number/description/

// T.C. O(n)
// S.C. O(1)
private fun missingNumber(nums: IntArray): Int {
    var i = 0
    // sort the array using cyclic sort since range is given
    while (i <= nums.lastIndex) {
        val index = nums[i] // the correct index
        if (nums[i] <= nums.lastIndex && nums[i] != nums[index]) {
            swap(nums, i, index)
        } else {
            i++
        }
    }
    // find the missing number
    for (index in 0..nums.lastIndex) {
        if (nums[index] != index) {
            return index
        }
    }
    return nums.size
}

private fun swap(nums: IntArray, p: Int, q: Int) {
    val temp = nums[p]
    nums[p] = nums[q]
    nums[q] = temp
}

fun main() {
    println(missingNumber(intArrayOf(3, 0, 1)))
    println(missingNumber(intArrayOf(0, 1)))
    println(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}