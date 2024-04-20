package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/combination-sum-ii/description/

// T.C. O(2 ^ t) where t = target
private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    val subList = mutableListOf<Int>()

    candidates.sort()

    fun backtrack(index: Int, sum: Int) {
        if (sum == target) {
            // copy the list to prevent changing the original list
            if (!result.contains(subList))
                result.add(subList.toMutableList())
            return
        }
        if (index > candidates.lastIndex || sum > target) {
            return
        }

        // in our decision tree, we either take the current number or we don't take it
        // at all i.e. we never take any duplicates also
        subList.add(candidates[index])
        backtrack(index + 1, sum + candidates[index])

        subList.removeLastOrNull()
        // skip all duplicates
        var i = index
        while (i < candidates.lastIndex && candidates[i] == candidates[i + 1])
            i++
        backtrack(i + 1, sum)
    }

    backtrack(0, 0)
    return result
}


fun main() {
    println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
}