package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/spiral-matrix/description/

// T.C. O(m * n) where m = #rows and n = #columns
private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val ans = mutableListOf<Int>()

    // init boundary condition for rows
    var a = 0
    var b = matrix.size - 1

    // init boundary condition for columns
    var c = 0
    var d = matrix.first().size - 1

    // start by printing the row
    var row = true
    // print row in reverse or not
    var rowReverse = false
    // print column in reverse or not
    var colReverse = false

    while (a <= b && c <= d) {
        if (row) {
            // print row
            if (rowReverse) {
                // print(d -> c)
                for (i in d downTo c) {
                    ans.add(matrix[b][i])
                }
                b--
            } else {
                // print(c -> d)
                for (i in c..d) {
                    ans.add(matrix[a][i])
                }
                a++
            }
            // print in reverse order next time
            rowReverse = !rowReverse
        } else {
            // print column
            if (colReverse) {
                // print(b -> a)
                for (i in b downTo a) {
                    ans.add(matrix[i][c])
                }
                c++
            } else {
                // print(a -> b)
                for (i in a..b) {
                    ans.add(matrix[i][d])
                }
                d--
            }
            // print in reverse order next time
            colReverse = !colReverse
        }
        // print column if row printed and vice-versa
        row = !row
    }
    return ans
}

fun main() {
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    println(spiralOrder(matrix1).joinToString())

    val matrix2 = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )
    println(spiralOrder(matrix2).joinToString())

    val matrix3 = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
    )
    println(spiralOrder(matrix3).joinToString())
}