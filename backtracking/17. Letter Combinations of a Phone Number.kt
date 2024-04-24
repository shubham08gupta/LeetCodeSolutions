package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// T.C. O(4 ^ n)
// S.C. O(4 ^ n)

private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val map = mapOf(
        2 to "abc",
        3 to "def",
        4 to "ghi",
        5 to "jkl",
        6 to "mno",
        7 to "pqrs",
        8 to "tuv",
        9 to "wxyz",
    )

    fun bfs(): List<String> {
        val deck = ArrayDeque<String>()
        deck.add("")

        // if we look at the expected answer, it's length should be equal to the length of digits string,
        // so keep looping until that condition is not met
        while (deck.first().length != digits.length) {
            val removed = deck.removeFirst()
            // get the mapping
            val digitString = map[digits[removed.length] - '0']!!
            // add each char of this string until our while condition is satisfied
            for (char in digitString) {
                deck.addLast(removed + char)
            }
        }
        return deck
    }


    val result = mutableListOf<String>()
    val subList = mutableListOf<Char>()
    val digitList: List<String> = digits.mapNotNull {
        map[it.digitToInt()]
    }

    fun dfs(index: Int) {
        if (index > digitList.lastIndex) {
            result.add(subList.joinToString(""))
            return
        }

        // go through every character of every string
        for (char in digitList[index]) {
            subList.add(char)
            dfs(index + 1)
            subList.removeLastOrNull()
        }
    }

//    dfs(0)
//    return result
    return bfs()
}

fun main() {
    println(letterCombinations("23"))
    println(letterCombinations("239"))
    println(letterCombinations("2"))
    println(letterCombinations(""))
}