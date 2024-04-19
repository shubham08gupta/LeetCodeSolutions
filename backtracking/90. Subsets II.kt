package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/subsets-ii/description/

// T.C. O(n * 2^n)
// S.C. O(n)
fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    // we want to skip the same elements so sort them to easily skip them
    nums.sort()

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
        subset.removeLastOrNull()

        // skip same elements
        var i = index
        while (i + 1 < nums.size && nums[i] == nums[i + 1])
            i++

        dfs(i + 1)
    }

    dfs(0)

    return result
}

fun main() {
    println(subsetsWithDup(intArrayOf(1, 2, 2)))
    println(subsetsWithDup(intArrayOf(0)))
    println(subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)))
}