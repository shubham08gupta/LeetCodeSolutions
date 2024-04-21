package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/word-search/
private fun exist(board: Array<CharArray>, word: String): Boolean {
    // keep track of the visit so that same letter is not visited again
    val visited = Array(board.size) { BooleanArray(board[0].size) { false } }

    fun helper(
        row: Int,
        col: Int,
        pos: Int,
    ): Boolean {
        // check out of bounds
        // check if the word formed until now is still valid or not
        if (row < 0 || row >= board.size || col < 0 || col >= board[0].size || visited[row][col] || pos >= word.length || board[row][col] != word[pos])
            return false
        if (pos == word.length - 1)
            return true
        visited[row][col] = true

        // go in all directions
        if (helper(row - 1, col, pos + 1) ||
            helper(row, col + 1, pos + 1) ||
            helper(row + 1, col, pos + 1) ||
            helper(row, col - 1, pos + 1)
        ) return true

        visited[row][col] = false
        return false
    }

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == word[0] && helper(i, j, 0)) {
                return true
            }
        }
    }
    return false
}

fun main() {
    val matrix1 = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    )
    println(exist(matrix1, "ABCCED"))
    println(exist(matrix1, "SEE"))
    println(exist(matrix1, "ABCB"))
}