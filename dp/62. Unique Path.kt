package com.example.myapplication.leetcode.dp

// https://leetcode.com/problems/unique-paths/description/
fun uniquePaths(m: Int, n: Int): Int {

    // using DP

    // T.C. O(n * m)
    // S.C. O(n * m)
    fun solution1(): Int {
        // if we see clearly by making a diagrams, it represents tree with overlapping sub-problems
        // saves the unique paths for each m,n so that if it's already computed, no need to re-compute
        val dp = Array(m) { IntArray(n) { 0 } }

        /**
        r = current row
        c = current col
         */
        fun countPaths(r: Int, c: Int): Int {
            if (r > m - 1 || c > n - 1) return 0
            if (r == m - 1 && c == n - 1) {
                return 1
            }

            if (dp[r][c] != 0) {
                return dp[r][c]
            }

            dp[r][c] = countPaths(r + 1, c) + countPaths(r, c + 1)
            return dp[r][c]
        }

        return countPaths(0, 0)
    }

    // using combination formula Ncr
    // T.C. O(m) or O(n)
    // S.C. O(1)
    fun solution2(): Int {
        val N = n + m - 2
        val r = m - 1
        var res = 1.0

        // eg: 10c3 = (8 * 9 * 10) / 3 * 2 * 1
        // so calculating like 8/1 * 9/2 * 10/3
        for (i in 1..r) {
            res = res * (N - r + i) / i
        }

        return res.toInt()
    }

//    return solution1()
    return solution2()
}

fun main() {
    println(uniquePaths(3, 7))
    println(uniquePaths(15, 15))
}