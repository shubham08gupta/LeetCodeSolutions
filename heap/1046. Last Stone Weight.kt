package com.example.myapplication.leetcode.heap

import java.util.PriorityQueue
import kotlin.math.abs

// https://leetcode.com/problems/last-stone-weight/

// T.C. O(n logn)
// S.C. O(n)
private fun lastStoneWeight(stones: IntArray): Int {
    // need highest 2 elements so use a max heap
    val maxHeap = PriorityQueue<Int>(stones.size, compareByDescending { it })
    for (stone in stones) {
        maxHeap.offer(stone)
    }
    while (maxHeap.size > 1) {
        // pick the top two elements
        val x = maxHeap.poll() ?: continue
        val y = maxHeap.poll() ?: continue
        // check the result
        if (x != y) {
            maxHeap.offer(abs(y - x))
        }
    }
    return if (maxHeap.isEmpty()) {
        0
    } else {
        maxHeap.remove()
    }
}

fun main() {
    println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    println(lastStoneWeight(intArrayOf(2, 2, 4, 1, 8, 1)))
    println(lastStoneWeight(intArrayOf(1)))
}