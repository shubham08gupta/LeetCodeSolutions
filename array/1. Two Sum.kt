package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/two-sum/description/
fun twoSum(nums: IntArray, target: Int): IntArray {
    val a = intArrayOf(0, 0)
    val map = mutableMapOf<Int, Int>()
    for (i in 0..nums.lastIndex) {
        val key = nums[i]
        if (map.containsKey(target - key)) {
            a[0] = map[target - key]!!
            a[1] = i
            break
        } else {
            map[key] = i
        }
    }
    return a
}