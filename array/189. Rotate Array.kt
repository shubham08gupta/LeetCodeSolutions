package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/rotate-array/description/
private fun rotate(nums: IntArray, k: Int) {
    // if we see carefully, if n == k the answer after the rotation is the same array
    // so that's why we just use the modulo
    val K = k % nums.size
    nums.reverse(0, nums.size - K)
    nums.reverse(nums.size - K, nums.size)
    nums.reverse()
    // println(nums.joinToString())
}

fun main() {
    rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
    rotate(intArrayOf(-1, -100, 3, 99), 2)
}