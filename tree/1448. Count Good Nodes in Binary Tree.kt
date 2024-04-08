package com.example.myapplication.leetcode.tree

var count = 0

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
fun goodNodes(root: TreeNode?): Int {
    root ?: 0
    countGood(root, root!!.`val`)
    return count
}

// T.C. O(n)
// S.C. O(1)
fun countGood(root: TreeNode?, max: Int) {
    root ?: return
    if (root.`val` >= max) {
        count++
    }
    // pass the maximum value found until now to compare with child nodes
    val currMax = maxOf(max, root.`val`)
    // pre-order traversal
    countGood(root.left, currMax)
    countGood(root.right, currMax)
}