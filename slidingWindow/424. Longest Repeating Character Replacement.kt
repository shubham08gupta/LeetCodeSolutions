package com.example.myapplication.leetcode.slidingWindow

// https://leetcode.com/problems/longest-repeating-character-replacement/description/

private fun characterReplacement(s: String, k: Int): Int {
    var l = 0
    var maxFreq = 0 // count the most occurring character
    var ans = 0
    val arr = IntArray(26) // s only contains uppercase English letter

    // no need to write while (l < r) as r should always increase because
    // once we find a valid window we do no need to decrease window length;
    // we always want the max window
    for (r in 0..s.lastIndex) {
        val length = r - l + 1
        arr[s[r] - 'A']++
        maxFreq = maxOf(maxFreq, arr[s[r] - 'A'])
        // check how many chars do we need to change to satisfy the condition
        if (length - maxFreq <= k) {
            ans = maxOf(ans, length)
        } else {
            arr[s[l] - 'A']--
            l++
        }
    }
    return ans
}

fun main() {
    val s1 = "ABAB"
    println(characterReplacement(s1, 2))

    val s2 = "AABABBA"
    println(characterReplacement(s2, 1))

    val s3 = "ZZZZZZZ"
    println(characterReplacement(s3, 2))

    val s4 = "B"
    println(characterReplacement(s4, 1))

    val s5 = "ABCDEF"
    println(characterReplacement(s5, 3))
}