package com.example.myapplication.leetcode.slidingWindow

// https://leetcode.com/problems/sliding-window-maximum/description/

// T.C. O(n)
// S.C. O(n)
private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    // by checking different k values I figured out
    // what will be the size of output array
    val ans = IntArray(nums.size - k + 1)
    var index = 0 // array index
    // maintains the indices of nums array in decreasing order
    val deck = ArrayDeque<Int>()
    for (r in 0..nums.lastIndex) {
        // remove out of window elements from queue
        while (deck.isNotEmpty() && r - (k - 1) > deck.first()) {
            deck.removeFirst()
        }

        // maintain Deque in decreasing order
        while (deck.isNotEmpty() && nums[r] > nums[deck.last()]) {
            deck.removeLast()
        }
        deck.addLast(r)

        // check if window size is valid
        if (r - (k - 1) >= 0) {
            ans[index] = nums[deck.first()]
            index++
        }
    }
    return ans
}

fun main() {
    println(maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).joinToString())
    println(maxSlidingWindow(intArrayOf(1), 1).joinToString())
}