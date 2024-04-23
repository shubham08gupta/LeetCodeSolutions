package com.example.myapplication.leetcode.backtracking

// https://leetcode.com/problems/palindrome-partitioning/description/

// T.C. O(2 ^ n)

private fun partition(s: String): List<List<String>> {
    val result = mutableListOf<MutableList<String>>()
    val subList = mutableListOf<String>()

    fun isPalindrome(str: String): Boolean {
        var l = 0
        var r = str.lastIndex
        while (l < r) {
            if (str[l] != str[r])
                return false
            l++
            r--
        }
        return true
    }


    fun backtrack(index: Int) {
        if (index > s.lastIndex) {
            result.add(subList.toMutableList())
            return
        }

        // check each substring
        for (i in index..s.lastIndex) {
            val sub = s.substring(index, i + 1)
            // only recurse for valid palindrome strings
            if (isPalindrome(sub)) {
                subList.add(sub)
                // start making substrings from the next character
                backtrack(i + 1)
                subList.removeLastOrNull()
            }
        }
    }

    backtrack(0)
    return result
}

fun main() {
    println(partition("aab"))
    println(partition("a"))
}