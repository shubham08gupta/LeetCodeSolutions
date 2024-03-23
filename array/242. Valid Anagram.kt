package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/valid-anagram/description/

// T.C. O(m + n) where m = s.length and n = t.length
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val map = mutableMapOf<Char, Int>()
    for (char in s) {
        map[char] = map.getOrElse(char) { 0 } + 1
    }
    for (char in t) {
        if (map.containsKey(char)) {
            // remove chars from map
            if (map[char] == 1) {
                map.remove(char)
            } else {
                map[char] = map[char]!! - 1
            }
        } else {
            map[char] = 1
        }

    }
    return map.isEmpty()
}

fun main() {
    println(isAnagram("", ""))
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
    println(isAnagram("tata", "tata"))
}