package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/combination-sum/

// T.C. O(2 ^ t) where t = target
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    /**
     * @param index the current array index
     * @param sum the current sum until now
     * @param subList list to store all combinations
     */
    fun backtrack(index: Int, sum: Int, subList: MutableList<Int>) {
        if (sum == target) {
            // copy the list to prevent changing the original list
            result.add(subList.toMutableList())
            return
        }
        if (index > candidates.lastIndex || sum > target) {
            return
        }

        // to prevent duplicate subList, either take the current number or don't

        // take the current number
        subList.add(candidates[index])
        backtrack(index, sum + candidates[index], subList)

        // don't take the current number and move to the next number
        subList.removeLastOrNull()
        backtrack(index + 1, sum, subList)
    }

    backtrack(0, 0, mutableListOf())
    return result
}

fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(combinationSum(intArrayOf(2, 3, 5), 8))
    println(combinationSum(intArrayOf(2), 1))
}
