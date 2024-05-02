package com.example.myapplication.leetcode.heap

import java.util.PriorityQueue

// https://leetcode.com/problems/k-closest-points-to-origin/description/

// T.C. O(n logk)
// S.C. O(k)

private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

    val ans = Array(k) { intArrayOf() }

    val maxHeap = PriorityQueue<IntArray>(
        k,
        // custom comparator which takes distance from origin as it's comparison key
        compareByDescending { point -> point[0] * point[0] + point[1] * point[1] }
    )

    points.forEach { point ->
        maxHeap.offer(point)
        if (maxHeap.size > k) {
            maxHeap.poll()
        }
    }

    repeat(k) {
        ans[it] = maxHeap.remove()
    }

    return ans
}

private fun printArrayFormatted(array: Array<IntArray>) {
    array.forEach {
        print("[${it[0]}, ${it[1]}], ")
    }
    println()
}

fun main() {
    printArrayFormatted(kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1))
    printArrayFormatted(
        kClosest(
            arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)),
            2
        )
    )
}