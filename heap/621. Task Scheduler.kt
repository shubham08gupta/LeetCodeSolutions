package com.example.myapplication.leetcode.heap

import java.util.ArrayDeque
import java.util.PriorityQueue

// https://leetcode.com/problems/task-scheduler/

// T.C. - O(n)
// S.C. - O(n)
/**
 * We are not actually arranging the letters as explained in the question, we just use the frequency
 * of the characters. Also we are doing this because we can arrange in any way, no ordering is
 * required
 */
private fun leastInterval(tasks: CharArray, n: Int): Int {
    // used to count the intervals required
    var intervals = 0
    val map = mutableMapOf<Char, Int>()
    for (task in tasks) {
        map[task] = map.getOrElse(task) { 0 } + 1
    }
    // create a max heap to store the frequency of each character such that max freq is at top
    // using max freq will give us the least intervals (try it with example)
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    map.values.forEach { freq ->
        maxHeap.offer(freq)
    }
    // use queue to store a character which was just scheduled, and after what time it is ready
    // to be scheduled again
    val queue = ArrayDeque<Pair<Int, Int>>()
    while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
        intervals++

        if (maxHeap.isNotEmpty()) {
            // consume it by decreasing it's count (or frequency)
            val freq = maxHeap.remove() - 1
            // can't consume 0 frequency characters
            if (freq != 0) {
                // char can be used again only after n time
                queue.addLast(Pair(freq, intervals + n))
            }

        }

        // queue will be in ascending order, so no need of while loop to check which items can be
        // removed
        // put into the heap after the cooling time to be scheduled again
        if (queue.isNotEmpty() && queue.first().second == intervals) {
            maxHeap.offer(queue.removeFirst().first)
        }
    }
    return intervals
}

fun main() {
    println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
    println(leastInterval(charArrayOf('A', 'C', 'A', 'B', 'D', 'B'), 1))
    println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 3))
}