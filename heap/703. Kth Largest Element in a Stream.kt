package com.example.myapplication.leetcode.heap

import java.util.PriorityQueue

// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

class KthLargest(private val k: Int, nums: IntArray) {

    private val minHeap = PriorityQueue<Int>() // by default it's a min heap

    init {
        for (num in nums) {
            minHeap.add(num)
        }
    }

    fun add(`val`: Int): Int {
        minHeap.add(`val`) // or minHeap.offer(`val`)
        // maintain heap of size k
        while (minHeap.size > k) {
            minHeap.poll()
        }
        // root element is the Kth largest element since we considered the heap size to be K exactly
        return minHeap.peek()
    }

}

fun main() {
    val obj = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(obj.add(3))
    println(obj.add(5))
    println(obj.add(10))
    println(obj.add(9))
    println(obj.add(4))
}