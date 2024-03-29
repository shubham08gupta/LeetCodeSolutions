package com.example.myapplication.leetcode.array


// https://leetcode.com/problems/find-the-duplicate-number/

private fun findDuplicate(nums: IntArray): Int {
    var i = 0
    // use cyclic sort because range is given
    // not exactly sorting as there are duplicates
    while (i <= nums.lastIndex) {
        // each number should be at its correct index, if not, swap it with its correct index
        // for eg: the number 2 should be at its correct index 1
        val correctIndex = nums[i] - 1
        // keep swapping and don't increase i until the correct number is found
        if (nums[i] != nums[correctIndex]) {
            swap(nums, i, correctIndex)
        } else {
            i++
        }
    }

    for (index in 0..nums.lastIndex) {
        if (index + 1 != nums[index]) {
            return nums[index]
        }
    }

    return nums.size
}

private fun swap(nums: IntArray, first: Int, second: Int) {
    val temp = nums[first]
    nums[first] = nums[second]
    nums[second] = temp
}

fun main() {
    val arr = intArrayOf(1, 3, 4, 2, 2)
    println(findDuplicate(arr))

    val arr2 = intArrayOf(3, 1, 3, 4, 2)
    println(findDuplicate(arr2))

    val arr3 = intArrayOf(3, 3, 3, 3)
    println(findDuplicate(arr3))
}