package com.example.myapplication.leetcode.twoPointers

// https://leetcode.com/problems/longest-consecutive-sequence/

// O(n)
fun longestConsecutive(nums: IntArray): Int {
    // there may be duplicates so remove them
    val set = nums.toSet()
    var max = 0
    for (num in set) {
        // eg: 1,2,3,4,   100,   200
        // for 100, there is nothing before, similarly for 200 there is nothing before. This is the
        // logic to check.
        // makes sure that we are not checking the same numbers again and again and keep T.C. O(n)
        if (!set.contains(num - 1)) {
            var curr = 0
            // start checking continuous numbers
            // check for 1, then 2, then 3, and so on..
            // similarly, check for 100, then 101, and so on...
            while (set.contains(num + curr)) {
                curr++
            }
            max = maxOf(max, curr)
        }

    }
    return max
}

fun main() {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
}