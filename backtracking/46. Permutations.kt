package com.example.myapplication.leetcode.backtracking

// T.C. O(n! * n)
// S.C. O(n)

fun permute(nums: IntArray): List<List<Int>> {
    val list = mutableListOf<MutableList<Int>>()

    fun backtrack(subList: MutableList<Int>) {

        // add only when all permutations are found
        if (subList.size == nums.size) {
            list.add(subList.toMutableList())
            return
        }

        for (num in nums) {
            // prevent taking duplicates
            if (subList.contains(num)) {
                continue
            }
            subList.add(num)
            backtrack(subList)
            subList.removeLastOrNull()
        }
    }

    backtrack(mutableListOf())
    return list
}

fun main() {
    println(permute(intArrayOf(1, 2, 3)))
    println(permute(intArrayOf(1, 2)))
    println(permute(intArrayOf(1)))
}