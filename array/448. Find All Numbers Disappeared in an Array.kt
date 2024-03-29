package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

// T.C. O(n)
// S.C. O(1) as O/P array is not considered to be taking space as given in the question
private fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val ans = mutableListOf<Int>()

    var i = 0
    // use cyclic sort because range is given
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

    // some numbers are not at their correct index and these are disappeared numbers
    nums.forEachIndexed { index, num ->
        if (num != index + 1) {
            ans.add(index + 1)
        }
    }
    return ans
}

private fun swap(nums: IntArray, first: Int, second: Int) {
    val temp = nums[first]
    nums[first] = nums[second]
    nums[second] = temp
}

fun main() {
    val arr = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    println(findDisappearedNumbers(arr).joinToString())

    val arr2 = intArrayOf(1, 1)
    println(findDisappearedNumbers(arr2).joinToString())
}