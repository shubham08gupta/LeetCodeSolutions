package com.example.myapplication.leetcode.backtracking

import kotlin.math.abs

// https://leetcode.com/problems/n-queens/description/

fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()

    val positions = mutableListOf<Pair<Int, Int>>()
    val board = mutableListOf<CharArray>()

    for (i in 0 until n) {
        board.add(CharArray(n))
        for (j in 0 until n) {
            board[i][j] = '.'
        }
    }

    fun backtrack(row: Int) {
        if (positions.size == n) {
            result.add(board.map { it.joinToString("") })
            return
        }

        for (col in 0 until n) {
            // check if the queen can be placed here or not
            if (canAdd(row, col, positions)) {
                positions.add(Pair(row, col))
                board[row][col] = 'Q'

                // check for the next row
                backtrack(row + 1)

                board[row][col] = '.'
                positions.removeLast()
            }
        }

    }

    backtrack(0)

    return result
}

private fun canAdd(i: Int, j: Int, positions: List<Pair<Int, Int>>): Boolean {
    if (positions.isEmpty()) {
        return true
    }

    return freeRow(i, positions) && freeColumn(j, positions) && freeDiagonal(i, j, positions)
}

private fun freeRow(i: Int, positions: List<Pair<Int, Int>>): Boolean {
    return positions.all { it.first != i }
}

private fun freeColumn(j: Int, positions: List<Pair<Int, Int>>): Boolean {
    return positions.all { it.second != j }
}

private fun freeDiagonal(i: Int, j: Int, positions: List<Pair<Int, Int>>): Boolean {
    return positions.all {
        abs(it.first - i) != abs(it.second - j)
    }
}


fun main() {
    println(solveNQueens(1))
    println(solveNQueens(2))
    println(solveNQueens(3))
    println(solveNQueens(4))
}