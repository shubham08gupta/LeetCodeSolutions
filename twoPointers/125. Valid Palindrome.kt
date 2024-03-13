package com.example.myapplication.leetcode.twoPointers

fun isPalindrome(str: String): Boolean {
    val s = str.toLowerCase()
    var l = 0
    var r = s.lastIndex
    while (l < r) {
        if (!s[l].isLetterOrDigit()) {
            l++
            continue
        }
        if (!s[r].isLetterOrDigit()) {
            r--
            continue
        }
        if (s[l] != s[r])
            return false
        l++
        r--
    }
    return true
}

fun main() {
    val str1 = "A man, a plan, a canal: Panama"
    val str2 = "race a car"
    val str3 = " "
    val str4 = ",."
    println(isPalindrome(str1))
    println(isPalindrome(str2))
    println(isPalindrome(str3))
    println(isPalindrome(str4))
}