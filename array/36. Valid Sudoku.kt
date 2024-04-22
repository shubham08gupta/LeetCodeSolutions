package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/valid-sudoku/

// T.C. O(m * n)
// S.C. O(n)
private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rowMap = mutableMapOf<Char, Int>()
    val colMap = mutableMapOf<Char, Int>()

    // check all rows and columns together
    for (i in 0..8) {
        rowMap.clear()
        colMap.clear()
        for (j in 0..8) {
            if (board[i][j] != '.') {
                rowMap[board[i][j]] = rowMap.getOrElse(board[i][j]) { 0 } + 1
                if (rowMap[board[i][j]]!! > 1) {
                    return false
                }
            }
            if (board[j][i] != '.') {
                colMap[board[j][i]] = colMap.getOrElse(board[j][i]) { 0 } + 1
                if (colMap[board[j][i]]!! > 1) {
                    return false
                }
            }
        }
    }

    // check all 3 * 3 grids
    for (i in 0..8 step 3) {
        for (j in 0..8 step 3) {
            if (!checkBox(i, i + 2, j, j + 2, board)) {
                return false
            }
        }
    }

    return true
}

private fun checkBox(sr: Int, er: Int, sc: Int, ec: Int, board: Array<CharArray>): Boolean {
    val map = mutableMapOf<Char, Int>()
    for (i in sr..er) {
        for (j in sc..ec) {
            if (board[i][j] != '.') {
                val value = map.getOrElse(board[i][j]) { 0 }
                if (value >= 1) {
                    return false
                } else {
                    map[board[i][j]] = value + 1
                }
            }

        }
    }
    return true
}

fun main() {
    val matrix1 = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    val matrix2 = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    println(isValidSudoku(matrix1))
    println(isValidSudoku(matrix2))
}