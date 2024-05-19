package com.example.myapplication.leetcode.heap

import java.util.PriorityQueue

// https://leetcode.com/problems/find-median-from-data-stream/
private class MedianFinder {

    // maintain two heaps such that all elements in the maxHeap are smaller than all elements in the
    // min heap
    private val minHeap = PriorityQueue<Int>() // larger elements
    private val maxHeap = PriorityQueue<Int>(compareByDescending { it }) // smaller elements

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        // maintain similar size of both the heaps
        // max diff b/w heaps can be 1 based on whether size is even or odd
        if (maxHeap.size - minHeap.size > 1) {
            minHeap.offer(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        val even = (maxHeap.size + minHeap.size) % 2 == 0
        return if (even) (maxHeap.peek() + minHeap.peek()) / 2.0
        else maxHeap.peek().toDouble()
    }

}

fun main() {
    /**
     * Your MedianFinder object will be instantiated and called as such:
     */
    val obj = MedianFinder()
    obj.addNum(1)
    obj.addNum(2)
    println(obj.findMedian())
    obj.addNum(3)
    println(obj.findMedian())
}