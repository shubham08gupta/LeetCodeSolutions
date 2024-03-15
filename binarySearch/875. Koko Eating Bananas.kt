package com.example.myapplication.leetcode.binarySearch

// https://leetcode.com/problems/koko-eating-bananas/
class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max() // O(n)
        // O(log M) where M is 1 .. max
        while (left < right) {
            val mid = left + (right - left) / 2
            if (condition(piles, h, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun condition(piles: IntArray, h: Int, k: Int): Boolean {
        // count how many hours would be required to eat each pile
        var hours = 0
        // O(n)
        for (pile in piles) {
            hours += pile / k
            // if pile < k, we can eat the entire pile at once so only 1 hour
            if (pile % k != 0) {
                hours++
            }
        }
        // return hours == h should be correct but bcoz of our while loop in
        // binary search, it will make the condition false and hence the answer will be wrong
        return hours <= h
    }
}

fun main() {
    val s = Solution()
    val arr1 = intArrayOf(3, 6, 7, 11)
    println(s.minEatingSpeed(arr1, 8))

    val arr2 = intArrayOf(30, 11, 23, 4, 20)
    println(s.minEatingSpeed(arr2, 5))

    val arr3 = intArrayOf(30, 11, 23, 4, 20)
    println(s.minEatingSpeed(arr3, 6))
}