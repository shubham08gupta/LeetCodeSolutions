package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/subsets/description/

// T.C. O(n * 2 ^ n)
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    // list containing all subsets
    val subset = mutableListOf<Int>()

    fun dfs(index: Int) {
        if (index > nums.lastIndex) {
            // copy the subset list otherwise we will change the generated subsets so far
            result.add(subset.toMutableList())
            return
        }

        // decision to include the current element
        subset.add(nums[index])
        dfs(index + 1)

        // decision to NOT include the current element
        subset.removeLast()
        dfs(index + 1)
    }

    dfs(0)

    return result
}

fun main() {
    println(subsets(intArrayOf(1, 2, 3)))
    println(subsets(intArrayOf(1, 2)))
    println(subsets(intArrayOf(1)))
}