package com.example.myapplication.leetcode.array

// https://leetcode.com/problems/3sum/description/
fun threeSum(nums: IntArray): List<List<Int>> {

    // T.C. O(n ^ 3)
    // S.C. O(1)
    // go through each element
    fun solution1(): List<List<Int>> {
        val ans = mutableSetOf<MutableList<Int>>()
        for (i in 0..nums.lastIndex) {
            for (j in i + 1..nums.lastIndex) {
                for (k in j + 1..nums.lastIndex) {
                    val first = nums[i]
                    val second = nums[j]
                    val third = nums[k]
                    if (first + second + third == 0) {
                        // sort the triplet to prevent duplicates
                        val triplet = mutableListOf(first, second, third).also { it.sort() }
                        ans.add(triplet)
                    }
                }
            }
        }
        return ans.toList()
    }

    // T.C. O(n ^ 2)
    // S.C. O(n)
    // prevent the inner most loop by searching the element in the set
    fun solution2(): List<List<Int>> {
        val ans = mutableSetOf<MutableList<Int>>()
        val set = mutableSetOf<Int>()
        for (i in 0..nums.lastIndex) {
            // we don't want previous elements to give us false positive answer
            set.clear()
            for (j in i + 1..nums.lastIndex) {
                val first = nums[i]
                val second = nums[j]
                val third = -1 * (first + second)
                if (set.contains(third)) {
                    val triplet = mutableListOf(first, second, third).also { it.sort() }
                    ans.add(triplet)
                }
                set.add(second)
            }
        }
        return ans.toList()
    }

    // T.C. O(n log n + n ^ 2)
    // S.C. O(1)
    // sort the input first and then search the third number
    fun solution3(): List<List<Int>> {
        nums.sort() // this prevents duplicates

        val ans = mutableListOf<MutableList<Int>>()
        for (i in 0..nums.lastIndex) {
            if (i != 0 && nums[i] == nums[i - 1]) continue

            var j = i + 1
            var k = nums.lastIndex
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum == 0) {
                    // storing the triplet in a sorted order; now we don't have to sort them
                    val triplet = mutableListOf(nums[i], nums[j], nums[k])
                    ans.add(triplet)
                    j++
                    k--
                    // skip all the same elements to prevent duplicate triplets
                    while (j < k && nums[j] == nums[j - 1]) j++
                    while (j < k && nums[k] == nums[k + 1]) k--
                } else if (sum < 0) {
                    // the sum is negative, which means to make it 0, we need to increase j (as it's sorted)
                    j++
                } else {
                    // the sum is positive; so we need to decrease it
                    k--
                }
            }
        }
        return ans
    }

//    return solution1()
//    return solution2()
    return solution3()
}

fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(0, 1, 1)))
    println(threeSum(intArrayOf(0, 0, 0)))
}